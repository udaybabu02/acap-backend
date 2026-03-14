package com.acap.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Table(name = "questions")
public class Question {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String subject; // e.g., "Java", "Python", "Testing"
    
    @Column(length = 1000)
    private String questionText;
    
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    
    private String correctAnswer; // e.g., "A", "B", "C", or "D"

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOptionA() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOptionB() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOptionC() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOptionD() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQuestionText1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQuestionText() {
		// TODO Auto-generated method stub
		return null;
	}
}