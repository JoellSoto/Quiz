package com.Tech.quiz.question.repository;

import com.Tech.quiz.answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    public <Optional> Answer findByName(String name);
}
