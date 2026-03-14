package com.acap.repo;

import com.acap.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    // This allows us to search the database for a specific email!
    Optional<User> findByEmail(String email);
    
}