package com.example.Request;

public class TopBidderDTO {

	private String name;
	private Long bidCount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getBidCount() {
		return bidCount;
	}
	public void setBidCount(Long bidCount) {
		this.bidCount = bidCount;
	}
	public TopBidderDTO(String name, Long bidCount) {
		super();
		this.name = name;
		this.bidCount = bidCount;
	}


}
