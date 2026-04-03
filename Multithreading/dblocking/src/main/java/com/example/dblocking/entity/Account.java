package Multithreading.dblocking.src.main.java.com.example.dblocking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Entity class mapped to DB table `account`
 *
 * What:
 * - Represents a row in the database
 *
 * Why:
 * - JPA uses this class to map Java objects ↔ DB rows
 *
 * How:
 * - Each field maps to a column
 * - `@Id` marks primary key
 */

@Entity
public class Account {
    
    @Id
    private Long id;
    private int balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
