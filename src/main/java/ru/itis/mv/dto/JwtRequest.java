package ru.itis.mv.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class JwtRequest {
    @NotEmpty(message = "email should not be empty")
    private String email;

    @NotEmpty(message = "password should not be empty")
    private String password;
}
