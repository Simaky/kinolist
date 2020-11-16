package me.simaky.kinolist.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Score> scoreList = new ArrayList<>();
}
