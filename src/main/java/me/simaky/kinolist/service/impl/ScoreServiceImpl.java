package me.simaky.kinolist.service.impl;

import me.simaky.kinolist.converter.ScoreConvertor;
import me.simaky.kinolist.dto.ScoreDto;
import me.simaky.kinolist.dto.UserFilmScoreDto;
import me.simaky.kinolist.exception.ApiException;
import me.simaky.kinolist.model.Film;
import me.simaky.kinolist.model.Score;
import me.simaky.kinolist.model.User;
import me.simaky.kinolist.model.id.ScoreId;
import me.simaky.kinolist.repository.ScoreRepository;
import me.simaky.kinolist.repository.UserRepository;
import me.simaky.kinolist.service.FilmService;
import me.simaky.kinolist.service.ScoreService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final UserRepository userRepository;
    private final ScoreRepository scoreRepository;
    private final FilmService filmService;

    public ScoreServiceImpl(UserRepository userRepository, ScoreRepository scoreRepository, FilmService filmService) {
        this.userRepository = userRepository;
        this.scoreRepository = scoreRepository;
        this.filmService = filmService;
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
    public UserFilmScoreDto save(UserFilmScoreDto userFilmScoreDto, Long userId, Long filmId) {
        User user = new User();
        user.setId(userId);

        Film film = filmService.findFilmById(filmId);
        if (film == null) {
            film = new Film(
                    userFilmScoreDto.getFilmId(),
                    userFilmScoreDto.getName(),
                    userFilmScoreDto.getDescription(),
                    userFilmScoreDto.getImageUrl(),
                    userFilmScoreDto.getSeriesCount(),
                    userFilmScoreDto.getMediaType()
            );
            film = filmService.save(film);
        }

        Score score = new Score();
        score.setUser(user);
        score.setFilm(film);
        score.setCurrentState(userFilmScoreDto.getScore().getCurrentState());
        score.setRating(userFilmScoreDto.getScore().getRating());
        score.setIsRecommended(userFilmScoreDto.getScore().getIsRecommended());

        validate(score);
        Score saved = scoreRepository.save(score);

        return ScoreConvertor.toDto(saved);
    }

    @Override
    public UserFilmScoreDto edit(ScoreDto score, Long userId, Long filmId) {
        Score dbScore = scoreRepository.findById(new ScoreId(filmId, userId)).orElse(null);
        if (dbScore == null) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, "score not found");
        }

        dbScore.setCurrentState(score.getCurrentState());
        dbScore.setRating(score.getRating());
        dbScore.setIsRecommended(score.getIsRecommended());

        validate(dbScore);
        scoreRepository.save(dbScore);

        return ScoreConvertor.toDto(dbScore);
    }

    @Override
    public void delete(Long filmId, Long userId) {
        ScoreId scoreId = new ScoreId(filmId, userId);

        if (!scoreRepository.existsById(scoreId)) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, "score not found");
        }
        scoreRepository.deleteById(scoreId);
    }

    @Override
    public UserFilmScoreDto getFilmScoreForUser(Long userId, Long filmId) {
        Score score = scoreRepository.findById(new ScoreId(filmId, userId)).orElse(null);
        if (score == null) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, "score not found");
        }
        return ScoreConvertor.toDto(score);
    }

    private void validate(Score score) {
        if (score.getCurrentState() > score.getFilm().getSeriesCount() || score.getCurrentState() < 0) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, "current state can't be bigger than film series count or lower than 0");
        }
        if (score.getRating() > 10 || score.getRating() < 0) {
            throw new ApiException(HttpServletResponse.SC_BAD_REQUEST, "rating can't be > 10 or < 0");
        }
    }
}
