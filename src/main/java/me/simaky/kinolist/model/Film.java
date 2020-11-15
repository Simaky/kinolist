package me.simaky.kinolist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "film")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Film {
    @Id
    private Long id;

    private String name;

    @Type(type = "text")
    private String description;
    @Type(type = "text")
    private String imageUrl;
    private Integer seriesCount;
    @Type(type = "text")
    private String mediaType;
}
