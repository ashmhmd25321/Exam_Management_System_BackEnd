package com.exam.examinationsystem.controller;

import com.exam.examinationsystem.models.exam.Category;
import com.exam.examinationsystem.models.exam.Quiz;
import com.exam.examinationsystem.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.addQuiz(quiz));
    }
    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
    {
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }
    //get quiz
    @GetMapping("/")
    public ResponseEntity<?> getQuizzes()
    {
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //get single quiz
    @GetMapping("{qid}")
    public Quiz getSingleQuiz(@PathVariable("qid") Long qid)
    {
        System.out.println("Getting single quiz");
        return this.quizService.getQuiz(qid);
    }
    //delete Quiz
    @DeleteMapping("/{qid}")
    public void deleteQuiz(@PathVariable("qid") Long qid)
    {
        System.out.println("Deleting quiz"+qid);
        this.quizService.deleteQuiz(qid);
    }

    //get quiz of particular category
    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizOfCategory(@PathVariable("cid") Long cid)
    {
        Category cat=new Category();
        cat.setCid(cid);
        return (this.quizService.getQuizzesOfCategory(cat));
    }

    //get active quizzes
    @GetMapping("/active")
    public List<Quiz> getActiveQuiz() {
        return this.quizService.getActiveQuizzes();
    }

    //get active quizzes by category
    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActiveQuizByCategory(@PathVariable("cid") Long cid) {
        Category category = new Category();
        category.setCid(cid);
        return this.quizService.getActiveQuizzesOfCategory(category);
    }

}
