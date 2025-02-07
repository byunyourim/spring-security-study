package com.example.springsecuritystudy.exception;

import java.util.Map;
import java.util.function.Consumer;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SecurityException.class)
    @Order(1)
    public ResponseEntity<CommonResponse<?>> exceptionHandelr(SecurityException exception) {
        Integer code = exception.getCode();
        String message = exception.getMessage();
        HttpStatus httpStatus = exception.getStatus();
        Map<String, Object> parameters = exception.getParameters();
        Consumer<String> logger = exception.getLogger();

        if (exception.getLogger() != null) {
            exception.getLogger().accept(exception.getMessage());
        }

        CommonResponse<?> response = new CommonResponse<>(code, message, parameters, logger);

        return ResponseEntity.status(httpStatus).body(response);
    }

    @ExceptionHandler(Exception.class)
    @Order(2)
    public static ResponseEntity<CommonResponse<?>> exceptionHandler(Exception e) {
        CommonResponse<?> response = new CommonResponse<>(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

    }
}
