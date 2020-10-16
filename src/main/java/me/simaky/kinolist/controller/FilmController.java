package me.simaky.kinolist.controller;

import me.simaky.kinolist.exception.ApiException;
import me.simaky.kinolist.model.Film;
import me.simaky.kinolist.service.FilmService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films/{id}")
    public Film filmById(@Valid @PathVariable Long id) {
        return filmService.findFilmById(id);
    }

    @GetMapping("/films")
    public List<Film> films() {
        return filmService.findFilms();
    }

    @PostMapping("/films")
    public Film addFilm(@Valid @RequestBody Film filmData) {
        Film film;

        try {
            film = filmService.save(filmData);
        } catch (Exception e) {
            throw new ApiException(400, e.getMessage());
        }

        return film;
    }
}
