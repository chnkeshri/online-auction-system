package com.example.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.dao.AuctionRepository;
import com.example.dao.BidRepository;
import com.example.model.Auction;
import com.example.model.Bid;
import com.example.response.GetAuctionBidsResponse;
import com.example.service.AuctionService;
import com.example.service.UserService;

public class AuctionServiceImpl implements AuctionService  {

	
	@Autowired
	  private AuctionRepository auctionRepository;

	  @Autowired
	  private BidRepository bidRepository;

	  @Autowired
	  private UserService userService;  

	  @Override
	  public Auction createAuction(Auction auction) {
	    auction.setStatus("OPEN");  
	    auction.setCreatedBy(userService.getCurrentUser());
	    return auctionRepository.save(auction);
	  }

	  @Override
	  public Auction getAuctionById(Long id) {
	    return auctionRepository.findById(id).orElse(null);
	  }

	  @Override
	  public List<Bid> getBidsForAuction(Long id) {
	    return bidRepository.findByAuctionIdOrderByAmountDesc(id);
	  }


	    @Override
	    public GetAuctionBidsResponse getCurrentBidsAndStatus(Long id) throws Exception {
	        Optional<Auction> optionalAuction = auctionRepository.findById(id);
	        if (!optionalAuction.isPresent()) {
	           throw new Exception();
	        }

	        Auction auction = optionalAuction.get();
	        Double highestBid = bidRepository.findHighestBidForAuction(id);

	        String auctionStatus;
	        LocalDateTime now = LocalDateTime.now();
	        if (auction.getStartTime().isBefore(now) && auction.getEndTime().isAfter(now)) {
	            auctionStatus = "OPEN";
	        } else if (auction.getEndTime().isBefore(now)) {
	            auctionStatus = "CLOSED";
	        } else {
	            auctionStatus = "NOT_STARTED";
	        }

	        return new GetAuctionBidsResponse(highestBid, auctionStatus);
	    }
}
