CREATE TABLE `score`
(
    `film_id`       BIGINT REFERENCES `film` (`id`),
    `user_id`       BIGINT REFERENCES `user` (`id`),
    `rating`        INT DEFAULT 0,
    `current_state` INT DEFAULT 0,
    PRIMARY KEY (`film_id`, `user_id`)
)