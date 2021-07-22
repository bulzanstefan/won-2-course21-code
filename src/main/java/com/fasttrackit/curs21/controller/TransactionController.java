package com.fasttrackit.curs21.controller;

import com.fasttrackit.curs21.model.Transaction;
import com.fasttrackit.curs21.model.TransactionType;
import com.fasttrackit.curs21.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    List<Transaction> getAll(@RequestParam(required = false) TransactionType type) {
        return service.getAll(type);
    }
}
