package com.Tech.quiz.Questions.controller;


import com.Tech.quiz.Questions.Entity.Question;
import com.Tech.quiz.Questions.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/user/questions")
@CrossOrigin(origins="*")
@AllArgsConstructor
public class QuestionsController {

    QuestionService questionService;

    @PostMapping("/create-question")
    public void createQuestin(@RequestBody Question question){
        questionService.createQuestion(question);
    }

    @PostMapping("/create-multiple-question")
   public void createMultipleQuestions(@RequestBody List<Question> questions){
        questionService.createMultipleQuestion(questions);
   }
    @GetMapping("/get-all")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestions();
    }
    @GetMapping("/get-twenty-five")
    public List<Question> get25(){
        return  questionService.get25Questions();
    }
    @PostMapping("/update-question")
    public void updateQuestion(@RequestParam("questionId") int questionId, @RequestBody Question question){
        questionService.updateQuestion(questionId,question);
    }

}
