package me.simaky.kinolist.controller;

import me.simaky.kinolist.dto.EditPasswordDto;
import me.simaky.kinolist.dto.UserDto;
import me.simaky.kinolist.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/current")
    public UserDto getCurrentUser() {
        return userService.getCurrentUser();
    }

    @GetMapping("/users/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/users/{userId}")
    public UserDto editUserById(@Valid @RequestBody UserDto userDto, @PathVariable Long userId) {
        return userService.editUserById(userId, userDto);
    }

    @PutMapping("/users/{userId}/password")
    public void changeUserPasswordById(@Valid @RequestBody EditPasswordDto editPasswordDto, @PathVariable Long userId) {
        userService.changeUserPasswordById(userId, editPasswordDto);
    }
}
