package com.acap.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExamStartResponse {
    private List<QuestionDto> questions;
    private int durationInMinutes;
}