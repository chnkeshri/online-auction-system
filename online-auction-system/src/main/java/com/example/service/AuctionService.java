package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Auction;
import com.example.model.Bid;
import com.example.response.GetAuctionBidsResponse;

@Service
public interface AuctionService {
	Auction createAuction(Auction auction);

	Auction getAuctionById(Long id);

	List<Bid> getBidsForAuction(Long id);

	
	
	 GetAuctionBidsResponse getCurrentBidsAndStatus(Long id) throws Exception;
}