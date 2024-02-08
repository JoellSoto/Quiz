package com.Tech.quiz.Questions.service.impl;


import com.Tech.quiz.Questions.Entity.Score;
import com.Tech.quiz.Questions.repository.ScoreRepository;
import com.Tech.quiz.Questions.service.ScoreService;
import com.Tech.quiz.UserManagement.entity.User;
import com.Tech.quiz.UserManagement.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ScoreServiceImpl implements ScoreService {

    private ScoreRepository scoreRepository;
    private UserRepository userRepository;

    public List<Score> getAllbyUser(int userId){
        User currentUser= userRepository.findById(userId).get();
        return scoreRepository.findByUser(currentUser).stream().toList();
    }
}
