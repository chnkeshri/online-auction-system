package com.example.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.response.DailyReport;
import com.example.service.ReportService;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVFormat;


public class AdministratorReportController {

	@Autowired
    private ReportService reportService;

    @GetMapping("/daily")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> getDailyReport() {
        DailyReport report = reportService.generateDailyReport();
       
        return ResponseEntity.ok(report); 
       
    }
  
    private ResponseEntity<byte[]> generateCsvResponse(DailyReport report) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CSVPrinter printer = new CSVPrinter((Appendable) outputStream, buildCsvFormat());
        writeReportDataToPrinter(printer, report);
        printer.flush();
        byte[] byteArray = outputStream.toByteArray();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
        headers.setContentDisposition(ContentDisposition.attachment()
                .filename("daily_report.csv")
                .build());

        return ResponseEntity.ok(byteArray);
    }

    private static CSVFormat buildCsvFormat() {
        return CSVFormat.DEFAULT;
    }
    private void writeReportDataToPrinter(CSVPrinter printer, DailyReport report) throws IOException {
        printer.printRecord("Date", "Total Auctions", "Total Bids", "Highest Bid");
        printer.printRecord(report.getDate().toString(), report.getTotalAuctions(), report.getTotalBids(), report.getHighestBidAmount());
    }
}
