package com.acap.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "results")
public class Result {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Links this result to a specific student
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String subject;
    private int score;
    private int totalQuestions;
    
    private LocalDateTime examDate = LocalDateTime.now();
}