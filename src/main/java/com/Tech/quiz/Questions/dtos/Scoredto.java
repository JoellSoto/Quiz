package com.Tech.quiz.Questions.dtos;


import com.Tech.quiz.Questions.Entity.Score;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Scoredto {
    private  int score;
    private int userId;

    public Scoredto(Score entity){
        score = entity.getScore();
    }
}
