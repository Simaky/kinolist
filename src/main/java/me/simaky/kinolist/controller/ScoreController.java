package me.simaky.kinolist.controller;

import me.simaky.kinolist.dto.ScoreDto;
import me.simaky.kinolist.dto.UserDto;
import me.simaky.kinolist.dto.UserFilmScoreDto;
import me.simaky.kinolist.exception.ApiException;
import me.simaky.kinolist.service.ScoreService;
import me.simaky.kinolist.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;


@RestController
@Validated
public class ScoreController {
    private final ScoreService scoreService;
    private final UserService userService;

    public ScoreController(ScoreService scoreService, UserService userService) {
        this.scoreService = scoreService;
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/films")
    public List<UserFilmScoreDto> scoresByUserId(@Valid @PathVariable Long userId) {
        return scoreService.getFilmListForUser(userId);
    }

    @GetMapping("/users/{userId}/films/{filmId}/scores")
    public UserFilmScoreDto scoresByUserId(@Valid @PathVariable Long userId, @PathVariable Long filmId) {
        return scoreService.getFilmScoreForUser(userId, filmId);
    }

    @PostMapping("/users/{userId}/films/{filmId}/scores")
    public UserFilmScoreDto saveScore(@Valid @RequestBody UserFilmScoreDto userFilmScoreDto, @PathVariable Long userId, @PathVariable Long filmId) {
        validateUser(userId);
        return scoreService.save(userFilmScoreDto, userId, filmId);
    }

    @PutMapping("/users/{userId}/films/{filmId}/scores")
    public UserFilmScoreDto editScore(@Valid @RequestBody ScoreDto scoreData, @PathVariable Long userId, @PathVariable Long filmId) {
        validateUser(userId);
        return scoreService.edit(scoreData, userId, filmId);
    }

    @DeleteMapping("/users/{userId}/films/{filmId}/scores")
    public void deleteScore(@Valid @PathVariable Long userId, @PathVariable Long filmId) {
        validateUser(userId);
        scoreService.delete(filmId, userId);
    }

    private void validateUser(Long userId) {
        UserDto user = userService.getCurrentUser();
        if (!userId.equals(user.getId())) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, "operation not allowed for current user");
        }
    }
}
