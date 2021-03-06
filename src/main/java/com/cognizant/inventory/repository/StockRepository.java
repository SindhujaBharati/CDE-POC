package com.cognizant.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.inventory.domain.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long>{
	
	@Query("SELECT s from Stock s WHERE s.stockName = ?1")
    Stock findByName(String stockName);
}
