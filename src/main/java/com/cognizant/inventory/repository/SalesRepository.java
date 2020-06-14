package com.cognizant.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.inventory.domain.SalesOrder;

@Repository
public interface SalesRepository extends JpaRepository<SalesOrder,Long>{

}
