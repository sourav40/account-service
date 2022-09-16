package edu.miu.cs590.accountservice.util;

import org.springframework.http.HttpStatus;

public class ResponseUtility {

    public static ServerResponse getSuccessfulServerResponse(String message) {
        return ServerResponse.builder()
                .success(true)
                .message(message)
                .httpStatus(HttpStatus.OK)
                .httpCode(HttpStatus.OK.value())
                .build();
    }

    public static ServerResponse getSuccessfulServerResponse(Object data, String message) {
        return ServerResponse.builder()
                .success(true)
                .message(message)
                .data(data)
                .httpStatus(HttpStatus.OK)
                .httpCode(HttpStatus.OK.value())
                .build();
    }
    public static ServerResponse getFailedServerResponse(String message) {
        return ServerResponse.builder()
                .success(false)
                .message(message)
                .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                .httpCode(HttpStatus.NOT_ACCEPTABLE.value())
                .build();
    }

    public static ServerResponse getFailedServerResponse(Object data, String message) {
        return ServerResponse.builder()
                .success(false)
                .message(message)
                .data(data)
                .httpStatus(HttpStatus.NOT_ACCEPTABLE)
                .httpCode(HttpStatus.NOT_ACCEPTABLE.value())
                .build();
    }
}