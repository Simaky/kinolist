package me.simaky.kinolist.controller;

import me.simaky.kinolist.dto.ScoreDto;
import me.simaky.kinolist.dto.UserFilmScoreDto;
import me.simaky.kinolist.exception.ApiException;
import me.simaky.kinolist.model.Film;
import me.simaky.kinolist.model.Score;
import me.simaky.kinolist.service.ScoreService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }


    @GetMapping("users/{userId}/films")
    public List<UserFilmScoreDto> scoresByUserId(@Valid @PathVariable Long userId) {
        return scoreService.getFilmListForUser(userId);
    }

    @PostMapping("users/{userId}/films/{filmId}/scores")
    public ScoreDto scoresByUserId(@Valid @RequestBody ScoreDto scoreData, @PathVariable Long userId, @PathVariable Long filmId) {
        try {
            return scoreService.save(scoreData, userId, filmId);
        } catch (Exception e) {
            throw new ApiException(400, e.getMessage());
        }
    }
}
