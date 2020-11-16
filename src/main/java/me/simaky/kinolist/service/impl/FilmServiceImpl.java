package me.simaky.kinolist.service.impl;

import me.simaky.kinolist.model.Film;
import me.simaky.kinolist.repository.FilmRepository;
import me.simaky.kinolist.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> findFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film findFilmById(Long id) {
        return filmRepository.findFirstById(id);
    }

    @Override
    public Film save(Film film){
        //TODO add validation
        return filmRepository.save(film);
    }
}
