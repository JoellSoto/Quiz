package com.Tech.quiz.UserManagement.dto;


import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {

    private String firstName,lastName,email,password;
}
