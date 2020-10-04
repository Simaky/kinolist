package me.simaky.kinolist.service.impl;

import me.simaky.kinolist.converter.UserConverter;
import me.simaky.kinolist.dto.RegistrationDataDto;
import me.simaky.kinolist.dto.UserDto;
import me.simaky.kinolist.model.User;
import me.simaky.kinolist.repository.UserRepository;
import me.simaky.kinolist.service.RegistrationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    final PasswordEncoder passwordEncoder;
    final UserRepository userRepository;

    public RegistrationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto saveUser(RegistrationDataDto registrationDataDto) throws Exception {
        String password = registrationDataDto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setPassword(encodedPassword);

        user.setEmail(registrationDataDto.getEmail());
        user.setUsername(registrationDataDto.getUsername());

        User dbUser = userRepository.findFirstByUsername(user.getUsername());
        if (dbUser != null) {
            throw new Exception(String.format("user with '%s' username already exist", user.getUsername()));
        }
        dbUser = userRepository.findFirstByEmail(user.getEmail());
        if (dbUser != null) {
            throw new Exception(String.format("user with '%s' email already exist", user.getEmail()));
        }

        return UserConverter.toDto(userRepository.save(user));
    }
}
