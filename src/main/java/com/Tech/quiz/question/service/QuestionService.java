package com.Tech.quiz.question.service;

import com.Tech.quiz.question.Entity.Question;

import java.util.List;

public interface QuestionService {
    void createQuestion(Question question);
    void createMultipleQuestion(List<Question> questions);
    List<Question> getAllQuestions();
    List <Question> get25Questions();
    void deleteQuestion(int questionId);
    void updateQuestion(int questionId,Question question);

}
