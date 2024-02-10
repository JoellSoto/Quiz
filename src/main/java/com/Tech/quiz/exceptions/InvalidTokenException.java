package com.Tech.quiz.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@Getter
@Setter
public class InvalidTokenException extends RuntimeException {

    private String message;
    private int status;
    private String errorCode;

    private String resource;

    public InvalidTokenException(String resource, int status, String errorCode, String message) {
        super(String.format("%s not found with error code %s", resource, HttpStatus.INTERNAL_SERVER_ERROR.name()));
        this.resource = resource;
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
    }

}