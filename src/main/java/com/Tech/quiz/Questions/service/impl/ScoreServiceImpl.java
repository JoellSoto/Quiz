package com.Tech.quiz.Questions.service.impl;


import com.Tech.quiz.Questions.Entity.Score;
import com.Tech.quiz.Questions.dtos.Scoredto;
import com.Tech.quiz.Questions.repository.ScoreRepository;
import com.Tech.quiz.Questions.service.ScoreService;
import com.Tech.quiz.UserManagement.entity.User;
import com.Tech.quiz.UserManagement.repository.UserRepository;
import com.Tech.quiz.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ScoreServiceImpl implements ScoreService {

    private ScoreRepository scoreRepository;
    private UserRepository userRepository;

    @Transactional
    public void createScore(Scoredto scoredto){
      User currentUser= userRepository.findById(scoredto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Score System", HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name() , "User not found!"));
      Score entity = new Score();
      entity.setScore(scoredto.getScore());
      entity.setUser(currentUser);

      List<Score>currentScores=currentUser.getScores();
      currentScores.add(entity);
      currentUser.setScores(currentScores);

      userRepository.save(currentUser);
      scoreRepository.save(entity);
    }


    public List<Score> getAllbyUser(int userId){
        User currentUser= userRepository.findById(userId).get();
        return scoreRepository.findByUser(currentUser).stream().toList();
    }
}
