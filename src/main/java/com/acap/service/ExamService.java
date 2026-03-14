package com.acap.service;

import com.acap.domain.Question;
import com.acap.dto.ExamStartResponse;
import com.acap.dto.QuestionDto;
import com.acap.repo.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamService {

    @Autowired
    private QuestionRepository questionRepository;

    public ExamStartResponse startExam(String subject) {
        List<Question> allQuestions = questionRepository.findBySubject(subject);
        Collections.shuffle(allQuestions);
        
        List<Question> selected = allQuestions.stream().limit(10).collect(Collectors.toList());
        
        List<QuestionDto> dtos = selected.stream().map(q -> new QuestionDto(
            q.getId(), q.getQuestionText(), q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD()
        )).collect(Collectors.toList());
        
      
        return new ExamStartResponse(dtos, 60); 
    }
}