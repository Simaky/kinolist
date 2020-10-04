package me.simaky.kinolist.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RegistrationDataDto {
    @NotNull(message = "username cannot be empty")
    private String username;
    @NotNull(message = "email cannot be empty")
    private String email;
    @NotNull(message = "password cannot be empty")
    private String password;
}
