CREATE TABLE `film`
(
    `id`           BIGINT AUTO_INCREMENT PRIMARY KEY,
    `name`         VARCHAR(45) NOT NULL,
    `description`  VARCHAR(500),
    `image_url`    VARCHAR(255),
    `series_count` INT         NOT NULL
)