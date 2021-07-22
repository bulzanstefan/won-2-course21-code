package com.fasttrackit.curs21.service;

import com.fasttrackit.curs21.model.Transaction;
import com.fasttrackit.curs21.model.TransactionType;
import com.fasttrackit.curs21.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getAll(TransactionType type) {
        if (type == null) {
            return repository.findAll();
        } else {
            return repository.findByType(type);
        }
    }
}
