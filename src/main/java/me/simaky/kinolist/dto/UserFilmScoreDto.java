package me.simaky.kinolist.dto;

import lombok.Data;

@Data
public class UserFilmScoreDto {
    private Long filmId;
    private String name;
    private String description;
    private String imageUrl;
    private Integer seriesCount;
    private String mediaType;

    private ScoreDto score;
}
