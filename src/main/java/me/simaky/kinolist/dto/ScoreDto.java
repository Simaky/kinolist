package me.simaky.kinolist.dto;

import lombok.Data;

@Data
public class ScoreDto {
    private Long filmId;
    private Long userId;

    private Integer rating;
    private Integer currentState;
}
