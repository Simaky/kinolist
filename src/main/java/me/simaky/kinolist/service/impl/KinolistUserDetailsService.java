package me.simaky.kinolist.service.impl;

import me.simaky.kinolist.dto.KinolistUserPrincipal;
import me.simaky.kinolist.model.User;
import me.simaky.kinolist.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KinolistUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public KinolistUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User user = userRepository.findFirstByUsername(login);
        if (user == null) {
            user = userRepository.findFirstByEmail(login);
        }
        if (user == null) {
            throw new UsernameNotFoundException(login);
        }

        return new KinolistUserPrincipal(user);
    }
}
