package me.simaky.kinolist.service.impl;

import me.simaky.kinolist.converter.UserConverter;
import me.simaky.kinolist.dto.EditPasswordDto;
import me.simaky.kinolist.dto.KinolistUserPrincipal;
import me.simaky.kinolist.dto.UserDto;
import me.simaky.kinolist.exception.ApiException;
import me.simaky.kinolist.model.User;
import me.simaky.kinolist.repository.UserRepository;
import me.simaky.kinolist.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto getCurrentUser() {
        Object userObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userObject instanceof KinolistUserPrincipal) {
            return UserConverter.toDto(userRepository.findFirstById(((KinolistUserPrincipal) userObject).getUser().getId()));
        }
        throw new ApiException(HttpServletResponse.SC_UNAUTHORIZED, "you are not authorized");
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserConverter.toDto(userRepository.findFirstById(id));
    }

    @Override
    public UserDto editUserById(Long id, UserDto userDto) throws RuntimeException {
        User dbUser = userRepository.findFirstByUsername(userDto.getUsername());
        if (dbUser != null && !dbUser.getUsername().equals(userDto.getUsername())) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, String.format("user with '%s' username already exist", userDto.getUsername()));
        }
        dbUser = userRepository.findFirstByEmail(userDto.getEmail());
        if (dbUser != null && !dbUser.getEmail().equals(userDto.getEmail())) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, String.format("user with '%s' email already exist", userDto.getEmail()));
        }

        dbUser = userRepository.findFirstById(userDto.getId());
        if (dbUser == null) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, String.format("user with '%s' id is not exist", userDto.getId()));
        }

        dbUser.setEmail(userDto.getEmail());
        dbUser.setUsername(userDto.getUsername());
        dbUser.setFirstName(userDto.getFirstName());
        dbUser.setLastName(userDto.getLastName());

        userRepository.save(dbUser);
        return UserConverter.toDto(dbUser);
    }

    @Override
    public void changeUserPasswordById(Long id, EditPasswordDto editPasswordDto) {
        String encodedPassword = passwordEncoder.encode(editPasswordDto.getPassword());

        User dbUser = userRepository.findFirstById(id);
        if (dbUser == null) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, String.format("user with '%s' id is not exist", id));
        }
        if (!passwordEncoder.matches(editPasswordDto.getCurrentPassword(), dbUser.getPassword())) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, String.format("wrong current password", id));
        }

        dbUser.setPassword(encodedPassword);

        userRepository.save(dbUser);
    }
}
