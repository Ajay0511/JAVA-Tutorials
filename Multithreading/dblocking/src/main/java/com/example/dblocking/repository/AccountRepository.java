package Multithreading.dblocking.src.main.java.com.example.dblocking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.dblocking.entity.Account;

import jakarta.persistence.LockModeType;

/**
 * Repository layer (DAO abstraction)
 *
 * What:
 * - Provides DB access methods
 *
 * Why:
 * - Avoid writing boilerplate JDBC code
 * - Spring Data auto-generates implementation
 *
 * How:
 * - Extends JpaRepository → gets CRUD methods
 * - Custom query with pessimistic lock
 */

public interface AccountRepository extends JpaRepository<Account, Long> {

    /**
     * Fetch row with DB-level lock
     *
     * What:
     * - Locks the selected row
     *
     * Why:
     * - Prevent multiple threads from updating same row simultaneously
     *
     * How:
     * - `PESSIMISTIC_WRITE` → translates to `SELECT ... FOR UPDATE`
     * - DB blocks other transactions until commit
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT a FROM Account a WHERE a.id = :id")
    Optional<Account> findByIdForUpdate(@Param("id") Long id);
} 
