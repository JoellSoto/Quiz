package com.Tech.quiz.Questions.service.impl;


import com.Tech.quiz.Questions.Entity.Score;
import com.Tech.quiz.Questions.repository.ScoreRepository;
import com.Tech.quiz.Questions.service.ScoreService;
import com.Tech.quiz.UserManagement.entity.User;
import com.Tech.quiz.UserManagement.repository.UserRepository;
import com.Tech.quiz.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ScoreServiceImpl implements ScoreService {

    private ScoreRepository scoreRepository;
    private UserRepository userRepository;

    public void createScore(Score score, int userId){
      User currentUser= userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Score System", HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name() , "User not found!"));
      score.setUser(currentUser);

      List<Score>currentScores=currentUser.getScores();
      currentScores.add(score);
      currentUser.setScores(currentScores);

      userRepository.save(currentUser);
      scoreRepository.save(score);
    }

    public List<Score> getAllbyUser(int userId){
        User currentUser= userRepository.findById(userId).get();
        return scoreRepository.findByUser(currentUser).stream().toList();
    }
}
