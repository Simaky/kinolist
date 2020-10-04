package me.simaky.kinolist.converter;

import me.simaky.kinolist.dto.UserDto;
import me.simaky.kinolist.model.User;

public class UserConverter {
    public static UserDto toDto(User user) {
        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());

        return userDto;
    }
}
