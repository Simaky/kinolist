package me.simaky.kinolist.converter;

import me.simaky.kinolist.dto.ScoreDto;
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
        ScoreDto scoreDto = new ScoreDto();

        scoreDto.setCurrentState(score.getCurrentState());
        scoreDto.setRating(score.getRating());
        scoreDto.setIsRecommended(score.getIsRecommended());

        dto.setScore(scoreDto);
        dto.setName(score.getFilm().getName());
        dto.setSeriesCount(score.getFilm().getSeriesCount());
        dto.setMediaType(score.getFilm().getMediaType());
        dto.setDescription(score.getFilm().getDescription());
        dto.setImageUrl(score.getFilm().getImageUrl());
        dto.setFilmId(score.getFilm().getId());

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
