package com.acap.dto;

import lombok.Data;

@Data
public class QuestionDto {
    private Long id;
    private String content;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    
    
    public QuestionDto(Long id, String content, String optionA, String optionB, String optionC, String optionD) {
        this.id = id;
        this.content = content;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }
}