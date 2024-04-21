package com.Tech.quiz.question.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @SequenceGenerator(
            name="Answer_sequence",
            sequenceName="Answer_sequence",
            allocationSize =1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator ="Answer_sequence"
    )
    @Column
    private int id;

    @Column
    private boolean isCorrect;

    @Column
    private  String name;

    @ManyToOne
    @JsonBackReference(value="Answer_Question")
    @JoinColumn(name = "answer_id",nullable=false,unique=false)
    private Question question;


    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", isCorrect=" + isCorrect +
                ", name='" + name + '\'' +
                ", question=" + question.getQuestion() +
                '}';
    }
}
