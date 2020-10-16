package me.simaky.kinolist.service.impl;

import me.simaky.kinolist.converter.ScoreConvertor;
import me.simaky.kinolist.dto.ScoreDto;
import me.simaky.kinolist.dto.UserFilmScoreDto;
import me.simaky.kinolist.model.Film;
import me.simaky.kinolist.model.Score;
import me.simaky.kinolist.model.User;
import me.simaky.kinolist.model.id.ScoreId;
import me.simaky.kinolist.repository.FilmRepository;
import me.simaky.kinolist.repository.ScoreRepository;
import me.simaky.kinolist.repository.UserRepository;
import me.simaky.kinolist.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final UserRepository userRepository;
    private final FilmRepository filmRepository;
    private final ScoreRepository scoreRepository;

    public ScoreServiceImpl(UserRepository userRepository, FilmRepository filmRepository, ScoreRepository scoreRepository) {
        this.userRepository = userRepository;
        this.filmRepository = filmRepository;
        this.scoreRepository = scoreRepository;
    }

    @Override
    public List<UserFilmScoreDto> getFilmListForUser(Long userId) {
        Optional<User> dbUser = userRepository.findById(userId);

        List<Score> scoreList = dbUser.map(User::getScoreList).orElse(null);

        if (scoreList == null) {
            return Collections.emptyList();
        }

        return ScoreConvertor.toDto(scoreList);
    }

    @Override
    public ScoreDto save(ScoreDto scoreDto) throws Exception {
        User user = userRepository.findById(scoreDto.getUserId()).orElse(null);

        Film film = filmRepository.findById(scoreDto.getFilmId()).orElse(null);

        ScoreId scoreId = new ScoreId();
        scoreId.setUserId(user.getId());
        scoreId.setFilmId(film.getId());

        Score score = new Score();
        score.setId(scoreId);
        score.setCurrentState(scoreDto.getCurrentState());
        score.setRating(scoreDto.getRating());

        //TODO add validation
        scoreRepository.save(score);
        scoreRepository.

        return scoreDto;
    }
}
