package com.Tech.quiz.question.repository;


import com.Tech.quiz.question.Entity.Score;
import com.Tech.quiz.UserManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    List<Score> findByUser(User user);
}
