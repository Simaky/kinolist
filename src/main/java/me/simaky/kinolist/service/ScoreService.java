package me.simaky.kinolist.service;

import me.simaky.kinolist.dto.ScoreDto;
import me.simaky.kinolist.dto.UserFilmScoreDto;

import java.util.List;

public interface ScoreService {
    List<UserFilmScoreDto> getFilmListForUser(Long userId);

    UserFilmScoreDto getFilmScoreForUser(Long userId, Long filmId);

    UserFilmScoreDto save(UserFilmScoreDto userFilmScoreDto, Long userId, Long filmId);

    UserFilmScoreDto edit(ScoreDto score, Long userId, Long filmId);

    void delete(Long filmId, Long userId);
}
