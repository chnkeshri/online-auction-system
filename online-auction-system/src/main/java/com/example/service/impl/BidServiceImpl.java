package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AuctionRepository;
import com.example.dao.BidRepository;
import com.example.model.Auction;
import com.example.model.Bid;
import com.example.service.BidService;

@Service
public class BidServiceImpl implements BidService {

  @Autowired
  private AuctionRepository auctionRepository;

  @Autowired
  private BidRepository bidRepository;

  @Override
  public Auction getAuction(Long id) {
    return auctionRepository.findById(id).orElse(null);
  }

  @Override
  public Double getCurrentHighestBid(Auction auction) {
    return bidRepository.findTopByAuctionOrderByAmountDesc(auction)
        .map(Bid::getAmount)
        .orElse(null);
  }

  @Override
  public Bid saveBid(Bid bid) {
    return bidRepository.save(bid);
  }
}