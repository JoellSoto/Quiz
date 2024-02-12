package com.Tech.quiz.exceptions.handler;

import com.Tech.quiz.exceptions.ResourceNotFoundException;
import com.Tech.quiz.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(){
        return ResponseEntity.badRequest().body("Incorrect user/Password!");
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setResource(ex.getResource());
        errorResponse.setErrorCode(ex.getErrorCode());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setResource(ex.getResource());
        errorResponse.setErrorCode(ex.getErrorCode());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}

