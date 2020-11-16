CREATE TABLE `film`
(
    `id`           BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name`         VARCHAR(45) NOT NULL,
    `description`  text,
    `image_url`    text,
    `series_count` INT         NOT NULL,
    `media_type`   text
)