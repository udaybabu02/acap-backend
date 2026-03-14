package com.acap.repo;

import com.acap.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    // THIS IS THE FIX: Renamed from findBySubjectTag to findBySubject
    List<Question> findBySubject(String subject);
}