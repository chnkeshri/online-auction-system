package com.example.controller;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Request.TopBidderDTO;
import com.example.dao.AuctionRepository;
import com.example.model.Auction;

@RestController
@RequestMapping("/api/v1")
public class ParticipantController {

    @Autowired
    private AuctionRepository auctionRepository; // Assuming ParticipantRepository exists

    @GetMapping("/top-bidders")
    public ResponseEntity<List<TopBidderDTO>> getTopBidders() {
        List<Auction> participants = auctionRepository.findAll();
        Map<String, Long> participantBidCounts = calculateParticipantBidCounts(participants);
        List<TopBidderDTO> topBidders = getTopNParticipants(participantBidCounts, 10);
        return ResponseEntity.ok(topBidders);
    }

    private Map<String, Long> calculateParticipantBidCounts(List<Auction> participants) {
        Map<String, Long> participantBidCounts = new HashMap<>();
        for (Auction auction : participants) {
            long bidCount = auction.getBids().size();
            participantBidCounts.put(auction.getItemName(), bidCount);
        }
        return participantBidCounts;
    }

    private List<TopBidderDTO> getTopNParticipants(Map<String, Long> participantBidCounts, int n) {
        return participantBidCounts.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder())) 
                .limit(n)
                .map(entry -> new TopBidderDTO(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList()); 
    }
   
}