package com.Tech.quiz.Questions.service;

import com.Tech.quiz.Questions.Entity.Score;

import java.util.List;

public interface ScoreService {
    void createScore(Score score);
    List<Score> getAllbyUser(int userId);

}
