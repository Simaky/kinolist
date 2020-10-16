package me.simaky.kinolist.dto;

import lombok.Data;

@Data
public class UserFilmScoreDto {
    private String name;
    private String description;
    private String imageUrl;
    private Integer seriesCount;

    private Integer rating;
    private Integer currentState;
}
