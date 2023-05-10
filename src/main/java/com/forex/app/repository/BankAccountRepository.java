package com.forex.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forex.app.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

}
