package com.Tech.quiz.Questions.service;

import com.Tech.quiz.Questions.Entity.Question;

import java.util.List;

public interface QuestionService {
    void createQuestion(Question question);
    List<Question> getAllQuestions();
    List <Question> get25Questions();
    void deleteQuestion(int questionId);
    void updateQuestion(int questionId,Question question);

}
