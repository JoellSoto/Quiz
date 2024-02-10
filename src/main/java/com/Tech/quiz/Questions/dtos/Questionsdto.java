package com.Tech.quiz.Questions.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class Questionsdto {
    public class QuestionDTO {
        private int id;
        private String content;
        private List<String> options;
        private int correct;

    }
}
