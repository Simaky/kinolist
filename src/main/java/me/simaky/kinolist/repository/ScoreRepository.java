package me.simaky.kinolist.repository;

import me.simaky.kinolist.model.Score;
import me.simaky.kinolist.model.id.ScoreId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScoreId> {
}
