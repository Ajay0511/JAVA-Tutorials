package Multithreading.dblocking.src.main.java.com.example.dblocking.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.dblocking.service.AccountService;

/**
 * Thread runner to simulate concurrent updates
 *
 * What:
 * - Starts multiple worker threads
 *
 * Why:
 * - Demonstrates real-world concurrency scenario
 *
 * How:
 * - Uses thread pool (ExecutorService)
 * - Each thread calls same service method
 */
@Configuration
public class ThreadRunner {
    @Bean
    CommandLineRunner run(AccountService accountService) {
        // Create thread pool with 4 threads
        return args -> {
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            for (int i = 1; i <= 4; i++) {
                int workerId = i;
                executorService.submit(() -> {
                    try{
                        accountService.updateBalance(workerId);
                    } catch (Exception e) {
                        System.out.println("Worker " + workerId + " encountered an error: " + e.getMessage());
                    }
                });
            }
            executorService.shutdown();
        };
    }
}
