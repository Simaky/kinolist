package me.simaky.kinolist.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    private Long id;

    @NotNull(message = "username cannot be empty")
    private String username;
    @NotNull(message = "email cannot be empty")
    private String email;
    private String firstName;
    private String lastName;
}
