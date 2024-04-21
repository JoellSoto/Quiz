package com.Tech.quiz.score.presentation;


import com.Tech.quiz.question.Entity.Score;
import com.Tech.quiz.question.dtos.Scoredto;
import com.Tech.quiz.score.service.ScoreService;
import lombok.AllArgsConstructor;
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
