package com.acap.dto;

import java.util.List;

public class ExamStartResponse {
    private List<QuestionDto> questions;
    private int durationInMinutes;

    // 1. Manually add the Constructor that Eclipse is asking for
    public ExamStartResponse(List<QuestionDto> questions, int durationInMinutes) {
        this.questions = questions;
        this.durationInMinutes = durationInMinutes;
    }

    // 2. Add an empty constructor (required for JSON)
    public ExamStartResponse() {}

    // 3. Add Getters and Setters
    public List<QuestionDto> getQuestions() { return questions; }
    public void setQuestions(List<QuestionDto> questions) { this.questions = questions; }

    public int getDurationInMinutes() { return durationInMinutes; }
    public void setDurationInMinutes(int durationInMinutes) { this.durationInMinutes = durationInMinutes; }
}