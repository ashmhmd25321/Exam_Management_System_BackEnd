package com.exam.examinationsystem.controller;

import com.exam.examinationsystem.models.exam.Question;
import com.exam.examinationsystem.models.exam.Quiz;
import com.exam.examinationsystem.service.QuestionService;
import com.exam.examinationsystem.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question)
    {
        System.out.println(question);
        return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
    {
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get quiz wise questions
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid)
    {
        Quiz quiz=this.quizService.getQuiz(qid);
        Set<Question> questions=quiz.getQuestions();
        int totalQuestions=Integer.parseInt(quiz.getNumberOfQuestion());
        List list=new ArrayList(questions);
        if(list.size()>totalQuestions)
        {
            list=list.subList(0,totalQuestions+1);
        }
        Collections.shuffle(list);

        return ResponseEntity.ok(list);
    }


    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getAllQuestionsOfQuizAdmin(@PathVariable("qid") Long qid)
    {
        Quiz quiz=new Quiz();
        quiz.setQid(qid);
        Set<Question> list=this.questionService.getQuestionOfQuiz(quiz);

        return ResponseEntity.ok(list);
    }


    //get a single question
    @GetMapping("/{quesid}")
    public Question getQuestion(@PathVariable("quesid") Long quesId)
    {
        return this.questionService.getQuestion(quesId);
    }


    //delete a single question
    @DeleteMapping("/{quesId}")
    public void deleteQuestion(@PathVariable("quesId") Long quesId)
    {
        this.questionService.deleteQuestion(quesId);
    }
}
