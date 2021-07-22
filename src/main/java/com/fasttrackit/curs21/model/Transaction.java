package com.fasttrackit.curs21.model;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private Integer id;
    private String product;
    private TransactionType type;
    private double amount;
    @OneToOne(cascade = ALL)
    private Approval approval;
    @OneToMany(cascade = ALL)
    private List<Note> notes;
    @ManyToOne
    private Account account;
    @ManyToMany
    private List<Category> categories;

    Transaction() {
    }

    public Transaction(String product, TransactionType type, double amount, Approval approval, List<Note> notes, Account account, List<Category> categories) {
        this.product = product;
        this.type = type;
        this.amount = amount;
        this.approval = approval;
        this.notes = notes;
        this.account = account;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
