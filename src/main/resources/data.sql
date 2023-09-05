-- Insert franchises
INSERT INTO franchise (name)
VALUES ('NOROFF'),
       ('Experis'),
       ('Another Franchise'),
       ('Test Franchise'),
       ('Fifth Franchise'),
       ('Sixth Franchise'),
       ('Seventh Franchise'),
       ('Eighth Franchise'),
       ('Ninth Franchise');

-- Insert characters
INSERT INTO character (alias, gender, name, photo)
VALUES ('Pegil Plagen', 'Male', 'Egil Hagen', 'linkedin.com'),
       ('Loc the sock', 'Female', 'Lucas Tran', 'linkedin.com'),
       ('Tage in a cage', 'Male', 'Egil Hagen', 'linkedin.com'),
       ('Character X', 'Male', 'Creator 1', 'linkedin.com'),
       ('Character Y', 'Female', 'Creator 2', 'linkedin.com'),
       ('Character Z', 'Male', 'Creator 3', 'linkedin.com'),
       ('Character W', 'Male', 'Creator 4', 'linkedin.com'),
       ('Character V', 'Female', 'Creator 5', 'linkedin.com'),
       ('Character U', 'Male', 'Creator 6', 'linkedin.com'),
       ('Character T', 'Male', 'Creator 7', 'linkedin.com'),
       ('Character S', 'Female', 'Creator 8', 'linkedin.com');

-- Insert movies
INSERT INTO movie (franchise_id, release_year, director, genre, poster, title, trailer)
VALUES ('1', '1996', 'Egil Hagen', 'Horror', 'www.linkedin.com', 'Egil på tur', 'www.youtube.com'),
       ('1', '2000', 'Lucas Tran', 'Horror', 'www.linkedin.com', 'Lucas på tur', 'www.youtube.com'),
       ('1', '2004', 'Tage Munthe Berg', 'Horror', 'www.linkedin.com', 'Tage on trip', 'www.youtube.com'),
       ('2', '2020', 'Lucas, Egil og Tage', 'Komedie/Drama', 'www.linkedin.com', 'Three eeee musketeer',
        'www.youtube.com'),
       ('3', '2005', 'Director A', 'Action', 'www.imdb.com', 'Movie A', 'www.youtube.com'),
       ('4', '2010', 'Director B', 'Comedy', 'www.imdb.com', 'Movie B', 'www.youtube.com'),
       ('5', '2015', 'Director C', 'Drama', 'www.imdb.com', 'Movie C', 'www.youtube.com'),
       ('6', '2022', 'Director D', 'Sci-Fi', 'www.imdb.com', 'Movie D', 'www.youtube.com'),
       ('7', '2023', 'Director E', 'Fantasy', 'www.imdb.com', 'Movie E', 'www.youtube.com'),
       ('8', '2018', 'Director F', 'Thriller', 'www.imdb.com', 'Movie F', 'www.youtube.com'),
       ('9', '2019', 'Director G', 'Mystery', 'www.imdb.com', 'Movie G', 'www.youtube.com');

-- Assign characters to movies
INSERT INTO movie_character (character_id, movie_id)
VALUES ('1', '1'),
       ('2', '2'),
       ('3', '3'),
       ('1', '4'),
       ('2', '4'),
       ('3', '4'),
       ('4', '5'),
       ('6', '5'),
       ('4', '6'),
       ('5', '6'),
       ('6', '6'),
       ('4', '7'),
       ('6', '7'),
       ('4', '8'),
       ('5', '8'),
       ('6', '8'),
       ('8', '9'),
       ('9', '9');
