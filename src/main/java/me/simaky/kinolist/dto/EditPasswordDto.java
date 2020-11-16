package me.simaky.kinolist.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EditPasswordDto {
    @NotNull(message = "current password cannot be empty")
    private String currentPassword;
    @NotNull(message = "password cannot be empty")
    private String password;
}
