package com.Tech.quiz.Questions.repository;

import com.Tech.quiz.Questions.Entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Integer> {

    public <Optional> Answer findByName(String name);
}
