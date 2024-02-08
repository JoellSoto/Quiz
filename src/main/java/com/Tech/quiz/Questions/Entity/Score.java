package com.Tech.quiz.Questions.Entity;


import com.Tech.quiz.UserManagement.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Score {

    @Id
    @SequenceGenerator(
            name="Score_sequence",
            sequenceName="Score_sequence",
            allocationSize =1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator ="Score_sequence"
    )
    private int id;

    @Column
    private int score;


    @ManyToOne
    @JsonBackReference(value="User_Score")
    @JoinColumn(name = "user_id", nullable=false, unique=false)
    private User user;
}
