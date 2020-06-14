package com.cognizant.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.inventory.domain.PurchaseOrder;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseOrder,Long>{

}
