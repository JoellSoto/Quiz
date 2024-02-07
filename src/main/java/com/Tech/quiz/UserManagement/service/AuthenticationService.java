package com.Tech.quiz.UserManagement.service;

import com.Tech.quiz.UserManagement.entity.User;
import com.Tech.quiz.UserManagement.dto.JwtAuthenticationResponse;
import com.Tech.quiz.UserManagement.dto.RefreshTokenRequest;
import com.Tech.quiz.UserManagement.dto.SignInRequest;
import com.Tech.quiz.UserManagement.dto.SignUpRequest;

public interface AuthenticationService {
    public User signUp(SignUpRequest signUpRequest);
    public JwtAuthenticationResponse signIn(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest RefreshTokenRequest);
}
