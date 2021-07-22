package com.fasttrackit.curs21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Approval {
    @Id
    @GeneratedValue
    private Integer id;
    private boolean result;
    private LocalDateTime timestamp;
    private String person;

    Approval() {
    }

    public Approval(boolean result, LocalDateTime timestamp, String person) {
        this.result = result;
        this.timestamp = timestamp;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "id=" + id +
                ", result=" + result +
                ", timestamp=" + timestamp +
                ", person='" + person + '\'' +
                '}';
    }
}
