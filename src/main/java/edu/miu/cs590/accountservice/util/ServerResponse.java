package edu.miu.cs590.accountservice.util;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServerResponse {

    private HttpStatus httpStatus;

    private int httpCode;

    private boolean success;

    private String message;

    private Object data;
}
