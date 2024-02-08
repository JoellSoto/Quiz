package com.Tech.quiz.Questions.service;

import com.Tech.quiz.Questions.Entity.Score;
import com.Tech.quiz.Questions.dtos.Scoredto;

import java.util.List;

public interface ScoreService {
    void createScore(Scoredto scoreDto);
    List<Score> getAllbyUser(int userId);

}
