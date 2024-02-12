package com.Tech.quiz.UserManagement.service.impl;


import com.Tech.quiz.UserManagement.dto.*;
import com.Tech.quiz.UserManagement.entity.Roles;
import com.Tech.quiz.UserManagement.entity.User;
import com.Tech.quiz.UserManagement.repository.RoleRepository;
import com.Tech.quiz.UserManagement.repository.UserRepository;
import com.Tech.quiz.UserManagement.service.AuthenticationService;
import com.Tech.quiz.UserManagement.service.JWTService;
import com.Tech.quiz.exceptions.ResourceNotFoundException;
import com.Tech.quiz.exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final RoleRepository roleRepository;

    @Transactional
    public User signUp(SignUpRequest signUpRequest) {
        Roles role;
        User user= new User();
        role=roleRepository.findByName("USER").get();
        if(userRepository.findByEmail(signUpRequest.getEmail().toUpperCase()).isPresent()){
           throw new ResourceNotFoundException("System Sign-Up", HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.name() , "E-mail already in use");
        }
        else {
            user.setEmail(signUpRequest.getEmail().toUpperCase());
            user.setFirstName(signUpRequest.getFirstName());
            user.setSecondName(signUpRequest.getLastName());
            user.setRoles(Collections.singletonList(role));
            user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            return userRepository.save(user);

        }

    }

    @Transactional
    public User signIn(SignInRequest signInRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail().toLowerCase(),signInRequest.getPassword()));
        } catch (Exception e) {
            throw new UserNotFoundException("System Login", HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.NOT_FOUND.name() , "Incorrect Credentials!!");
        }

        var user=userRepository.findByEmail(signInRequest.getEmail().toLowerCase()).orElseThrow(()-> new UserNotFoundException("System Login", HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.NOT_FOUND.name() , "Incorrect Credentials!"));
        var acessToken= jwtService.generateToken(user);
        var refreshToken= jwtService.generateRefreshToken(new HashMap<>(), user);

        JwtAuthenticationResponse jwtAuthenticationResponse= new JwtAuthenticationResponse();
        jwtAuthenticationResponse.setToken(acessToken);
        jwtAuthenticationResponse.setRefreshToken(refreshToken);
        user.setJwtAuthenticationResponse(jwtAuthenticationResponse);

        return user;
    }

    public TokenState isTokenExpired(String token){
        TokenState tokenState=new TokenState();
        boolean isTokenExpired=jwtService.isTokenExpired(token);
        tokenState.setTokenExpired(isTokenExpired);
        return tokenState;
    }

    @Transactional
    public JwtAuthenticationResponse refreshToken(RefreshTokenRequest RefreshTokenRequest) {
        String userEmail = jwtService.extractUserName(RefreshTokenRequest.getToken());
        User user = userRepository.findByEmail(userEmail).orElseThrow();
        if(jwtService.isTokenValid(RefreshTokenRequest.getToken(), user)) {
            var acessToken= jwtService.generateToken(user);

            JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse();
            jwtAuthenticationResponse.setToken(acessToken);
            jwtAuthenticationResponse.setRefreshToken(RefreshTokenRequest.getToken());
            return jwtAuthenticationResponse;
        }
        return null;
    }

}
