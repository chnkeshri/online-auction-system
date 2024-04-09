package com.example.service;

import com.example.model.Auction;
import com.example.model.Bid;

public interface BidService {

	  Auction getAuction(Long id);

	  Double getCurrentHighestBid(Auction auction);

	  Bid saveBid(Bid bid);
	}