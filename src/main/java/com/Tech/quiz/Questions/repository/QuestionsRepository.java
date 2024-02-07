package com.Tech.quiz.Questions.repository;

import com.Tech.quiz.Questions.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM question ORDER BY random() LIMIT 25")
    List<Question> findRandomQuestions();
}
