package com.example.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Auction;
@Repository
public interface AuctionRepository extends JpaRepository<Auction, Long>{
	
	 List<Auction> findByEndTimeBefore(LocalDateTime endTime);
	 List<Auction> findByEndDateGreaterThanEqual(@Param("endDate") LocalDate endDate);
	}


