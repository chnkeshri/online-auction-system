package com.example.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AuctionRepository;
import com.example.dao.BidRepository;
import com.example.model.Auction;
import com.example.model.Bid;
import com.example.response.DailyReport;
import com.example.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired
    private BidRepository bidRepository;

    @Override
    public DailyReport generateDailyReport() {
        LocalDate today = LocalDate.now(); 
        List<Auction> auctions = auctionRepository.findByEndDateGreaterThanEqual(today);
        long totalAuctions = auctions.size();
        int totalBids = 0;
        double highestBid = 0.0;

        for (Auction auction : auctions) {
            List<Bid> bids = bidRepository.findByAuction(auction);
            totalBids += bids.size();
            OptionalDouble highestAuctionBid = bids.stream().mapToDouble(Bid::getAmount).max();
            double currentHighestBid = highestAuctionBid.orElse(0.0);
            if (currentHighestBid > highestBid) {
                highestBid = currentHighestBid;
            }
        }

        return new DailyReport(today, totalAuctions, (long) totalBids, highestBid);
    }
}