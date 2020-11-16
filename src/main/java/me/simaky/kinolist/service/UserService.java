package me.simaky.kinolist.service;

import me.simaky.kinolist.dto.EditPasswordDto;
import me.simaky.kinolist.dto.UserDto;

public interface UserService {
    UserDto getCurrentUser();

    UserDto getUserById(Long id);

    UserDto editUserById(Long id, UserDto userDto) throws RuntimeException;

    void changeUserPasswordById(Long id, EditPasswordDto editPasswordDto);
}
