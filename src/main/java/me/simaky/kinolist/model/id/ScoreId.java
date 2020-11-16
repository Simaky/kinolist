package me.simaky.kinolist.model.id;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
public class ScoreId implements Serializable {
    private Long film;
    private Long user;

    public ScoreId() {
    }
}
