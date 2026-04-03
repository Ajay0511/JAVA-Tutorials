package Multithreading.dblocking.src.main.java.com.example.dblocking.service;

import org.springframework.stereotype.Service;

import com.example.dblocking.entity.Account;
import com.example.dblocking.repository.AccountRepository;

import jakarta.transaction.Transactional;

/**
 * Service layer (business logic)
 *
 * What:
 * - Contains core logic for updating account
 *
 * Why:
 * - Keeps business logic separate from DB layer
 * - Enables transaction management
 *
 * How:
 * - Uses repository to fetch + update data
 */

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Updates account balance safely using DB locking
     *
     * What:
     * - Reads, modifies, and updates balance
     *
     * Why:
     * - Ensure only one thread updates at a time
     *
     * How:
     * - `@Transactional` → starts DB transaction
     * - `findByIdForUpdate()` → locks row
     * - Other threads wait until commit
     */
    @Transactional
    public void updateBalance(int workerId){
        System.out.println("Worker " + workerId + " is trying to update balance...");
        Account row = accountRepository.findByIdForUpdate(1L).orElseThrow(() -> new RuntimeException("Account not found"));

        System.out.println("Worker " + workerId + " has locked the row. Current balance: " + row.getBalance());

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        row.setBalance(row.getBalance() + 100);
        accountRepository.save(row);
        System.out.println("Worker " + workerId + " has updated the balance to: " + row.getBalance());

        /**
         * IMPORTANT:
         * - Transaction commits when method ends
         * - Lock is released AFTER commit
         * - Next waiting thread proceeds
         */
    }
}
