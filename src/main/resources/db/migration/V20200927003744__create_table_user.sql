CREATE TABLE `user`
(
    `id`         BIGINT AUTO_INCREMENT PRIMARY KEY,
    `username`   VARCHAR(45) NOT NULL,
    `email`      VARCHAR(45) NOT NULL,
    `password`   VARCHAR(64) NOT NULL,
    `first_name` VARCHAR(255),
    `last_name`  VARCHAR(255)
)