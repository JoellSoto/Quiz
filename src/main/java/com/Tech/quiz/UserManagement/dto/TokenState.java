package com.Tech.quiz.UserManagement.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenState {

    private boolean isTokenExpired;
}
