package com.Tech.quiz.question.service;

import com.Tech.quiz.question.Entity.Score;
import com.Tech.quiz.question.dtos.Scoredto;

import java.util.List;

public interface ScoreService {
    void createScore(Scoredto scoreDto);
    List<Score> getAllbyUser(int userId);

}
