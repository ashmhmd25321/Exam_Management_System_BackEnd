package com.exam.examinationsystem.service;

import com.exam.examinationsystem.models.exam.Category;
import com.exam.examinationsystem.models.exam.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public  Quiz getQuiz(Long quizId);

    public  void  deleteQuiz(Long quizId);

   public List<Quiz> getQuizzesOfCategory(Category cat);

    //get active quizzes
    public  List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOfCategory(Category c);


}
