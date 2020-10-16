package me.simaky.kinolist.model.id;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ScoreId implements Serializable {
    private Long film;
    private Long user;
}
