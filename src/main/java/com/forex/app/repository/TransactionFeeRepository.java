package com.forex.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forex.app.entity.TransactionFee;

@Repository
public interface TransactionFeeRepository extends JpaRepository<TransactionFee, Long>{

}
