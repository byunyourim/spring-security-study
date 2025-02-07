package com.example.springsecuritystudy.exception;

import java.util.Map;
import java.util.function.Consumer;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SecurityException extends RuntimeException{

    private final Integer code;
    private final String message;
    private final HttpStatus status;
    private final Map<String, Object> parameters;
    private final Consumer<String> logger;

    public SecurityException(ErrorCode errorCode) {
        this(errorCode, null, null);
    }

    public SecurityException(ErrorCode errorCode, Map<String, Object> parameters,
        Consumer<String> logger) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.status = errorCode.getStatus();
        this.parameters = parameters;
        this.logger = logger;
    }
}
