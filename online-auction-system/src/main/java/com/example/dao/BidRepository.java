package com.example.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Auction;
import com.example.model.Bid;

import jakarta.persistence.OneToMany;

public interface BidRepository extends JpaRepository<Bid, Long> {

	public  List<Bid> findByAuctionIdOrderByAmountDesc(Long auctionId);

	public Optional<Bid> findTopByAuctionOrderByAmountDesc(Auction auction);

	public Double findHighestBidForAuction(Long auctionId);

	 List<Bid> findByAuction(Auction auction);


}