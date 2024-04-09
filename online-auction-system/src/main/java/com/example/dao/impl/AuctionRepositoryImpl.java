package com.example.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.example.dao.AuctionRepository;
import com.example.model.Auction;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class AuctionRepositoryImpl implements AuctionRepository, JpaRepository<Auction, Long> {

	@Autowired
	private EntityManager entityManager;



	@Override
	public List<Auction> findByEndTimeBefore(LocalDateTime endTime) {
		TypedQuery<Auction> query = entityManager.createQuery("SELECT a FROM Auction a WHERE a.endTime < :endTime", Auction.class);
		query.setParameter("endTime", endTime);
		return query.getResultList();
	}



	@Override
	public Page<Auction> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Auction> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Optional<Auction> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}



	@Override
	public void delete(Auction entity) {
		// TODO Auto-generated method stub

	}



	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub

	}



	@Override
	public void deleteAll(Iterable<? extends Auction> entities) {
		// TODO Auto-generated method stub

	}



	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}



	@Override
	public <S extends Auction> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public <S extends Auction> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Auction> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public <S extends Auction> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public <S extends Auction, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Auction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Auction> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Auction> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Auction> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}



	@Override
	public <S extends Auction> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Auction> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteAllInBatch(Iterable<Auction> entities) {
		// TODO Auto-generated method stub

	}



	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub

	}



	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}



	@Override
	public Auction getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Auction getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Auction> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Auction> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Auction> findByEndDateGreaterThanEqual(LocalDate endDate) {
		TypedQuery<Auction> query = entityManager.createQuery("SELECT a FROM Auction a WHERE a.endDate >= :endDate", Auction.class);
		query.setParameter("endDate", endDate);
		return query.getResultList();

	}

}
