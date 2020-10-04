package me.simaky.kinolist.controller;

import me.simaky.kinolist.dto.RegistrationDataDto;
import me.simaky.kinolist.dto.UserDto;
import me.simaky.kinolist.exception.ApiException;
import me.simaky.kinolist.service.RegistrationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@CrossOrigin
@Validated
public class RegistrationController {
    final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
    public UserDto registration(@Valid @RequestBody RegistrationDataDto registrationDataDto) {
        UserDto user;

        try {
            user = registrationService.saveUser(registrationDataDto);
        } catch (Exception e) {
            throw new ApiException(400, e.getMessage());
        }

        return user;
    }
}
