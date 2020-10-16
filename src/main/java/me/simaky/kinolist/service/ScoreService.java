package me.simaky.kinolist.service;

import me.simaky.kinolist.dto.ScoreDto;
import me.simaky.kinolist.dto.UserFilmScoreDto;

import java.util.List;

public interface ScoreService {
    List<UserFilmScoreDto> getFilmListForUser(Long userId);

    ScoreDto save(ScoreDto score) throws Exception;
}
