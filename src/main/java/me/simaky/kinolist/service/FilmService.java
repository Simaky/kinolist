package me.simaky.kinolist.service;

import me.simaky.kinolist.model.Film;

import java.util.List;

public interface FilmService {
    List<Film> findFilms();

    Film findFilmById(Long id);

    Film save(Film film);
}
