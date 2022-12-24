package com.exam.examinationsystem.repository;

import com.exam.examinationsystem.models.exam.Question;
import com.exam.examinationsystem.models.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
