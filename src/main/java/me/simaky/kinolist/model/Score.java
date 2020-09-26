package me.simaky.kinolist.model;


import lombok.Data;
import me.simaky.kinolist.model.id.ScoreId;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "score")
@Data
public class Score implements Serializable {

    @EmbeddedId
    private ScoreId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("filmId")
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    private Integer rating;
    private Integer currentState;
}
