package com.acap.web;

import com.acap.domain.User;
import com.acap.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") 
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // --- 1. REGISTRATION ENDPOINT ---
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Log what Java received to the Eclipse Console for debugging
        System.out.println("Received Registration Request for: " + user.getEmail());

        // Check if email is missing or empty to prevent "Email is required" errors
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Email is required! Please check your form.");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // Check if the student already registered
        if (userRepository.findByEmail(user.getEmail().trim()).isPresent()) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "A user with this email already exists!");
            return ResponseEntity.badRequest().body(errorResponse);
        }

        // Set default role and save the user
        user.setRole("STUDENT");
        User savedUser = userRepository.save(user);
        
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "Registration successful!");
        successResponse.put("uniqueId", savedUser.getUniqueId());
        
        return ResponseEntity.ok(successResponse);
    }

    // --- 2. LOGIN ENDPOINT ---
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials) {
        // .trim() removes any accidental spaces from the frontend input
        String email = credentials.get("email") != null ? credentials.get("email").trim() : "";
        String password = credentials.get("password") != null ? credentials.get("password").trim() : "";

        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            Object dbPassword = user.getPassword();

            // DEBUG LOG: Check Eclipse Console to verify data matching
            System.out.println("--- Login Debug ---");
            System.out.println("Checking Email: " + email);
            System.out.println("DB Password: [" + dbPassword + "]");
            System.out.println("Typed Password: [" + password + "]");

            // Safe check: verify user exists and password is not null
            if (dbPassword != null && dbPassword.equals(password)) {
                Map<String, String> successResponse = new HashMap<>();
                successResponse.put("message", "Login successful!");
                successResponse.put("uniqueId", user.getUniqueId());
                successResponse.put("role", user.getRole());
                successResponse.put("email", user.getEmail());
                return ResponseEntity.ok(successResponse);
            }
        }

        // Failure response for incorrect credentials
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", "Invalid email or password.");
        return ResponseEntity.status(401).body(errorResponse);
    }
}