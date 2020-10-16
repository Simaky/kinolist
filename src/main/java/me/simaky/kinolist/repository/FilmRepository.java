package me.simaky.kinolist.repository;

import me.simaky.kinolist.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findFirstByNameContains(String name);

    Film findAllByNameContains(String name);

    Film findFirstById(Long id);

}
