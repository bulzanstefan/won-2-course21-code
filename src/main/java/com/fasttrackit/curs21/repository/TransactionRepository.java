package com.fasttrackit.curs21.repository;

import com.fasttrackit.curs21.model.Transaction;
import com.fasttrackit.curs21.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByType(TransactionType type);

    List<Transaction> findByAmountGreaterThan(double minAmount);

    List<Transaction> findByTypeAndAmountGreaterThan(TransactionType type, double minAmount);
}
