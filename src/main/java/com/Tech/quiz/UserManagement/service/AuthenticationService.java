package com.Tech.quiz.UserManagement.service;

import com.Tech.quiz.UserManagement.dto.*;
import com.Tech.quiz.UserManagement.entity.User;

public interface AuthenticationService {
    User signUp(SignUpRequest signUpRequest);
    User signIn(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest RefreshTokenRequest);
    TokenState isTokenExpired(String token);
}
