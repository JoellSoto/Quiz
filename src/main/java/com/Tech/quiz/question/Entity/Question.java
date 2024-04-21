package com.Tech.quiz.question.Entity;


import com.Tech.quiz.answer.domain.Answer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@Setter
@Getter
@Entity
@NoArgsConstructor
public class Question {

    @Id
    @SequenceGenerator(
            name="Question_sequence",
            sequenceName="Question_sequence",
            allocationSize =1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator ="Question_sequence"
    )
    @Column
    private int id;
    @Column
    private String question;

    @Column
    private String questionType;

    @JsonManagedReference(value="Answer_Question")
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    List<Answer> options;
}
