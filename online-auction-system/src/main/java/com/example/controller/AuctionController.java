package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Auction;
import com.example.response.GetAuctionBidsResponse;
import com.example.service.AuctionService;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

  @Autowired
  private AuctionService auctionService;

  @PostMapping("/create")
  public ResponseEntity<Auction> createAuction(@RequestBody Auction auction) {
    return ResponseEntity.ok(auctionService.createAuction(auction));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Auction> getAuction(@PathVariable Long id) {
    return ResponseEntity.ok(auctionService.getAuctionById(id));
  }

  @GetMapping("/{id}/bids")
  public ResponseEntity<GetAuctionBidsResponse> getHigeshtBidsForAuctionAndStatus(@PathVariable Long id) {
	  GetAuctionBidsResponse response = null;
	try {
		response = auctionService.getCurrentBidsAndStatus(id);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	    return ResponseEntity.ok(response);
  }
}