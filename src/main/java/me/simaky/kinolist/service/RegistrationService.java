package me.simaky.kinolist.service;

import me.simaky.kinolist.dto.RegistrationDataDto;
import me.simaky.kinolist.dto.UserDto;
import me.simaky.kinolist.model.User;

public interface RegistrationService {
    UserDto saveUser(RegistrationDataDto registrationDataDto) throws Exception;
}
