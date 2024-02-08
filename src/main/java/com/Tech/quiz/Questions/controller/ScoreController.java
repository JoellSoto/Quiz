package com.Tech.quiz.Questions.controller;


import com.Tech.quiz.Questions.Entity.Score;
import com.Tech.quiz.Questions.dtos.Scoredto;
import com.Tech.quiz.Questions.service.ScoreService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user/score")
@CrossOrigin(origins="*")
public class ScoreController {

    private ScoreService scoreService;


    @PostMapping("/create")
    public void createScore(@RequestBody Scoredto score){
        scoreService.createScore(score);
    }

    @GetMapping("get-score/{userId}")
    public List<Score> getScoresByUser(@PathVariable("userId") int userId){
        return scoreService.getAllbyUser(userId);
    }

}
