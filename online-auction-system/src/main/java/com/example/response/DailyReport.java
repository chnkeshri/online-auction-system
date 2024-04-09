package com.example.response;

import java.time.LocalDate;

public class DailyReport {

	private LocalDate date; 
	private Long totalAuctions;
	private Long totalBids;
	private Double highestBidAmount;

	

	public DailyReport(LocalDate date, long totalAuctions, long totalBids, double highestBidAmount) {
		this.date = date;
		this.totalAuctions = totalAuctions;
		this.totalBids = totalBids;
		this.highestBidAmount = highestBidAmount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getTotalAuctions() {
		return totalAuctions;
	}

	public void setTotalAuctions(Long totalAuctions) {
		this.totalAuctions = totalAuctions;
	}

	public Long getTotalBids() {
		return totalBids;
	}

	public void setTotalBids(Long totalBids) {
		this.totalBids = totalBids;
	}

	public Double getHighestBidAmount() {
		return highestBidAmount;
	}

	public void setHighestBidAmount(Double highestBidAmount) {
		this.highestBidAmount = highestBidAmount;
	}


}
