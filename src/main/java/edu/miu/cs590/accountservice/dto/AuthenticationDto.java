package edu.miu.cs590.accountservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthenticationDto {

    @NotNull(message = "Username is required.")
    private String username;

    @NotNull(message = "Password is required.")
    private String password;
}
