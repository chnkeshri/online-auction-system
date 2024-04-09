package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.AuctionRepository;
import com.example.model.Auction;
import com.example.model.Bid;
import com.example.service.BidService;

@RestController
@RequestMapping("/api/auctions/{auctionId}/bids")
public class BidController {

  @Autowired
  private BidService bidService;

  
  @Autowired
  private AuctionRepository auctionRepository; 
  
  
  @PostMapping
  public ResponseEntity<Bid> submitBid(@PathVariable Long auctionId, @RequestBody Bid bid) {
    Auction auction = bidService.getAuction(auctionId);
    if (auction == null || !auction.getStatus().equals("OPEN")) {
      return ResponseEntity.badRequest().build(); 
    }

    Double currentHighestBid = bidService.getCurrentHighestBid(auction);
    if (currentHighestBid != null && bid.getAmount() <= currentHighestBid) {
      return ResponseEntity.badRequest().build(); 
    }

    bid.setAuction(auction);
    Bid savedBid = bidService.saveBid(bid);
    auction.setStatus(savedBid.getAmount() > auction.getReservedPrice() ? "SUCCESS" : "OPEN");
    auctionRepository.save(auction);

    return ResponseEntity.ok(savedBid);
  }
}