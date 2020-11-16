delete from user where id=1;
delete from film where id=597;
delete from film where id=808;
delete from film where id=809;
delete from film where id=1408;
delete from film where id=1726;
delete from film where id=24428;
delete from film where id=63174;
delete from film where id=66788;
delete from film where id=109445;
delete from score where user_id=1 and film_id=597;
delete from score where user_id=1 and film_id=808;
delete from score where user_id=1 and film_id=809;
delete from score where user_id=1 and film_id=1408;
delete from score where user_id=1 and film_id=1726;
delete from score where user_id=1 and film_id=24428;
delete from score where user_id=1 and film_id=63174;
delete from score where user_id=1 and film_id=66788;
delete from score where user_id=1 and film_id=109445;

insert into user(`id`, `username`, `email`, `password`)
values (1, 'admin', 'admin@gmail.com', '$2a$10$M8emDLRMM6/TJo7OL/w9pe/CJODMvBScFJFJ2hc5ZygKw4jfNGvn2');

insert into film (`id`, `name`, `description`, `image_url`, `series_count`, `media_type`)
values
  (597, 'Titanic', '101-year-old Rose DeWitt Bukater tells the story of her life aboard the Titanic, 84 years later. A young Rose boards the ship with her mother and fiancé. Meanwhile, Jack Dawson and Fabrizio De Rossi win third-class tickets aboard the ship. Rose tells the whole story from Titanic''s departure through to its death—on its first and last voyage—on April 15, 1912.', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg', 1, 'movie'),
  (808, 'Shrek', 'It ain''t easy bein'' green -- especially if you''re a likable (albeit smelly) ogre named Shrek. On a mission to retrieve a gorgeous princess from the clutches of a fire-breathing dragon, Shrek teams up with an unlikely compatriot -- a wisecracking donkey.', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/iB64vpL3dIObOtMZgX3RqdVdQDc.jpg', 1, 'movie'),
  (809, 'Shrek 2', 'Shrek, Fiona and Donkey set off to Far, Far Away to meet Fiona''s mother and father. But not everyone is happy. Shrek and the King find it hard to get along, and there''s tension in the marriage. The fairy godmother discovers that Shrek has married Fiona instead of her Son Prince Charming and sets about destroying their marriage.', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/oljiDFPyMY437BRRV69AzVDSiKy.jpg', 1, 'movie'),
  (1408, 'House', 'Dr. Gregory House, a drug-addicted, unconventional, misanthropic medical genius, leads a team of diagnosticians at the fictional Princeton–Plainsboro Teaching Hospital in New Jersey.', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/lkvhReTBZ2Ksl0Dl5Oplsf6UYkF.jpg', 177, 'tv'),
  (1726, 'Iron Man', 'After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/78lPtwv72eTNqFW9COBYI0dWDJa.jpg', 1, 'movie'),
  (24428, 'The Avengers', 'When an unexpected enemy emerges and threatens global safety and security, Nick Fury, director of the international peacekeeping agency known as S.H.I.E.L.D., finds himself in need of a team to pull the world back from the brink of disaster. Spanning the globe, a daring recruitment effort begins!', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/RYMX2wcKCBAr24UyPD7xwmjaTn.jpg', 1, 'movie'),
  (63174, 'Lucifer', 'Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he''s away from the underworld, the greater the threat that the worst of humanity could escape.', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/4EYPN5mVIhKLfxGruy7Dy41dTVn.jpg', 75, 'tv'),
  (66788, '13 Reasons Why', 'After a teenage girl''s perplexing suicide, a classmate receives a series of tapes that unravel the mystery of her tragic choice.', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/nel144y4dIOdFFid6twN5mAX9Yd.jpg', 49, 'tv'),
  (109445, 'Frozen', 'Young princess Anna of Arendelle dreams about finding true love at her sister Elsa’s coronation. Fate takes her on a dangerous journey in an attempt to end the eternal winter that has fallen over the kingdom. She''s accompanied by ice delivery man Kristoff, his reindeer Sven, and snowman Olaf. On an adventure where she will find out what friendship, courage, family, and true love really means.', 'https://image.tmdb.org/t/p/w600_and_h900_bestv2/kgwjIb2JDHRhNk13lmSxiClFjVk.jpg', 1, 'movie');


insert into score(`film_id`, `user_id`, `rating`, `current_state`, `is_recommended`)
values
 (597, 1, 8, 0, 0),
 (808, 1, 8, 0, 1),
 (809, 1, 7, 0, 1),
 (1408, 1, 10, 177, 1),
 (1726, 1, 7, 0, 0),
 (24428, 1, 9, 0, 0),
 (63174, 1, 10, 75, 1),
 (66788, 1, 10, 49, 1),
 (109445, 1, 10, 0, 1);
