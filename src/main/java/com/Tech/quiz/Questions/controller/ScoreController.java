package com.Tech.quiz.Questions.controller;


import com.Tech.quiz.Questions.Entity.Score;
import com.Tech.quiz.Questions.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user/score")
@CrossOrigin(origins="*")
public class ScoreController {

    private ScoreService scoreService;

    @GetMapping("get-score/{userId}")
    public List<Score> getScoresByUser(@PathVariable("userId") int userId){
        return scoreService.getAllbyUser(userId);
    }

}
