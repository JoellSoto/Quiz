package com.Tech.quiz.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class UserNotFoundException extends RuntimeException {

    private String message;
    private int status;
    private String errorCode;
    private String resource;

    public UserNotFoundException(String resource, int status, String errorCode, String message) {
        super(String.format("%s not found with error code %s", resource, HttpStatus.NOT_FOUND.name()));
        this.resource = resource;
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }
}