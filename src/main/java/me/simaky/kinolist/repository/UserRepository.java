package me.simaky.kinolist.repository;

import me.simaky.kinolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmail(String email);

    User findFirstByUsername(String username);

    User findFirstById(Long id);
}
