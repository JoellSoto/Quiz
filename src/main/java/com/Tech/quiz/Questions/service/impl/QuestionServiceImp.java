package com.Tech.quiz.Questions.service.impl;

import com.Tech.quiz.Questions.Entity.Answer;
import com.Tech.quiz.Questions.Entity.Question;
import com.Tech.quiz.Questions.repository.AnswerRepository;
import com.Tech.quiz.Questions.repository.QuestionsRepository;
import com.Tech.quiz.Questions.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class QuestionServiceImp implements QuestionService {

    private QuestionsRepository questionsRepository;
    private AnswerRepository answerRepository;

    public void createQuestion(Question question){
        List<Answer> answers= question.getOptions();

        questionsRepository.save(question);
        answerRepository.saveAll(answers);
    }

    public List<Question> getAllQuestions(){
        return  questionsRepository.findAll();
    }

    public List <Question> get25Questions(){
        return questionsRepository.findRandomQuestions();
    }

    public void  deleteQuestion(int questionId){
        questionsRepository.deleteById(questionId);
    }

    public void updateQuestion(int questionId,Question question){
        Question questiontoUpdate = questionsRepository.findById(questionId).get();

        questiontoUpdate.setQuestion(question.getQuestion());
        questiontoUpdate.setOptions(question.getOptions());
        questionsRepository.save(questiontoUpdate);

    }

}
