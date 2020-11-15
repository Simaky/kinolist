delete from user where id=1;
delete from film where id<=10;
delete from score where user_id=1 and film_id<=10;

insert into user(`id`, `username`, `email`, `password`)
values (1, 'admin', 'admin@gmail.com', '$2a$10$M8emDLRMM6/TJo7OL/w9pe/CJODMvBScFJFJ2hc5ZygKw4jfNGvn2');

insert into film (`id`, `name`, `description`, `image_url`, `series_count`)
values
       (1, 'Naruto', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (2, 'Naruto 2', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (3, 'Naruto 3', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (4, 'Naruto 4', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (5, 'Naruto 5', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (6, 'Naruto 6', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (7, 'Naruto 7', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (8, 'Naruto 8', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (9, 'Naruto 9', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220'),
       (10, 'Naruto 10', 'Movie about idiot with cheats', 'https://upload.wikimedia.org/wikipedia/ru/1/11/Naruto-manga.jpg','220');

insert into score(`user_id`,`film_id`, `rating`, `current_state`)
values
(1,1,7,120),
(1,2,1,12),
(1,3,2,10),
(1,4,6,45),
(1,5,8,96),
(1,6,3,120),
(1,7,10,220),
(1,8,8,120),
(1,9,2,120),
(1,10,8,120);
