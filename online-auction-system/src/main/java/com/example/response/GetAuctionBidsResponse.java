package com.example.response;

public class GetAuctionBidsResponse {

	
	private Double currentHighestBid;
    private String auctionStatus;
	
	public Double getCurrentHighestBid() {
		return currentHighestBid;
	}
	public void setCurrentHighestBid(Double currentHighestBid) {
		this.currentHighestBid = currentHighestBid;
	}
	public String getAuctionStatus() {
		return auctionStatus;
	}
	public void setAuctionStatus(String auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
	public GetAuctionBidsResponse(Double currentHighestBid, String auctionStatus) {
		super();
		this.currentHighestBid = currentHighestBid;
		this.auctionStatus = auctionStatus;
	}
    
    
}
