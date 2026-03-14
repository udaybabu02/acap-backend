package com.acap.config;

import com.acap.domain.Question;
import com.acap.repo.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final QuestionRepository repo;

    public DataInitializer(QuestionRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() == 0) {
           
            for (int i = 1; i <= 20; i++) {
                repo.save(new Question() );
            }

          
            for (int i = 1; i <= 20; i++) {
                repo.save(new Question(
                ));
            }
            System.out.println("Data Initialized successfully!");
        }
    }
}