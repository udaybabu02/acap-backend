package com.acap.web;

import com.acap.dto.ExamStartResponse;
import com.acap.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exam")
@CrossOrigin(origins = "*")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping("/start")
    public ResponseEntity<ExamStartResponse> getExamQuestions(@RequestParam String subject) {
        // This matches the fetch in your Vue CandidateExam.vue!
        ExamStartResponse response = examService.startExam(subject);
        return ResponseEntity.ok(response);
    }
}