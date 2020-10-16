package me.simaky.kinolist.model;


import lombok.Data;
import me.simaky.kinolist.model.id.ScoreId;

import javax.persistence.*;

@Data
@Entity(name = "score")
@IdClass(ScoreId.class)
public class Score {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private Film film;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private Integer rating;
    private Integer currentState;
}
