package com.example.springsecuritystudy.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    INVALID_USERNAME(100, "Username not found", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD(101, "Password not found", HttpStatus.NOT_FOUND),
    INVALID_AUTHENTICATION(102, "Username and Password not found", HttpStatus.NOT_FOUND),
    NOT_AUTHORIZED(103, "Authorization is missing or invalid", HttpStatus.UNAUTHORIZED);

    private final Integer code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(Integer code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}
