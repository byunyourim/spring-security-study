package com.example.springsecuritystudy.exception;

import java.util.Map;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResponse<T> {
    private Integer code;
    private String message;
    private T body;
    private Map<String, Object> parameters;
    private Consumer<String> logger;

    public CommonResponse(T body) {
        this.code = 0;
        this.body = body;
    }

    public CommonResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResponse(Integer code, String message, Map<String, Object>parameters, Consumer<String> logger) {
        this.code = code;
        this.message = message;
        this.parameters = parameters;
        this.logger = logger;
    }
}
