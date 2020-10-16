package me.simaky.kinolist.converter;

import me.simaky.kinolist.dto.UserFilmScoreDto;
import me.simaky.kinolist.model.Score;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreConvertor {
    public static UserFilmScoreDto toDto(Score score) {
        if (score == null) {
            return null;
        }
        UserFilmScoreDto dto = new UserFilmScoreDto();

        dto.setCurrentState(score.getCurrentState());
        dto.setRating(score.getRating());

        dto.setName(score.getFilm().getName());
        dto.setSeriesCount(score.getFilm().getSeriesCount());
        dto.setDescription(score.getFilm().getDescription());
        dto.setImageUrl(score.getFilm().getImageUrl());

        return dto;
    }

    public static List<UserFilmScoreDto> toDto(List<Score> scores) {
        if (CollectionUtils.isEmpty(scores)) {
            return Collections.emptyList();
        }
        List<UserFilmScoreDto> dtoList = new ArrayList<>(scores.size());

        for (Score score : scores) {
            dtoList.add(toDto(score));
        }

        return dtoList;
    }
}
