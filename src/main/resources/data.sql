INSERT INTO franchise (name)
VALUES ('NOROFF'),
       ('Experis'),
       ('Another Franchise'),
       ('Test Franchise'),
       ('Fifth Franchise'),
       ('Sixth Franchise');

INSERT INTO character (alias, gender, name, photo)
VALUES ('Pegil Plagen', 'Male', 'Egil Hagen', 'linkedin.com'),
       ('Loc the sock', 'Female', 'Lucas Tran', 'linkedin.com'),
       ('Tage in a cage', 'Male', 'Egil Hagen', 'linkedin.com'),
       ('Character X', 'Male', 'Creator 1', 'linkedin.com'),
       ('Character Y', 'Female', 'Creator 2', 'linkedin.com'),
       ('Character Z', 'Male', 'Creator 3', 'linkedin.com');

INSERT INTO movie (franchise_id, movie_id, release_year, director, genre, poster, title, trailer)
VALUES ('1', '1', '1996', 'Egil Hagen', 'Horror', 'www.linkedin.com', 'Egil på tur', 'www.youtube.com'),
       ('1', '2', '200', 'Lucas Tran', 'Horror', 'www.linkedin.com', 'Lucas på tur', 'www.youtube.com'),
       ('1', '3', '2000', 'Tage Munthe Berg', 'Horror', 'www.linkedin.com', 'Tage on trip', 'www.youtube.com'),
       ('2', '4', '2020', 'Lucas, Egil og Tage', 'Komedie/Drama', 'www.linkedin.com', 'Three eeee musketeer',
        'www.youtube.com'),
       ('3', '5', '2005', 'Director A', 'Action', 'www.imdb.com', 'Movie A', 'www.youtube.com'),
       ('4', '6', '2010', 'Director B', 'Comedy', 'www.imdb.com', 'Movie B', 'www.youtube.com'),
       ('5', '7', '2015', 'Director C', 'Drama', 'www.imdb.com', 'Movie C', 'www.youtube.com'),
       ('6', '8', '2022', 'Director D', 'Sci-Fi', 'www.imdb.com', 'Movie D', 'www.youtube.com');
INSERT INTO movie_character (character_id, movie_id)
VALUES ('1', '1'),
       ('2', '2'),
       ('3', '3'),
       ('1', '4'),
       ('2', '4'),
       ('3', '4'),
       ('4', '5'),
       ('5', '5'),
       ('6', '5'),
       ('4', '6'),
       ('5', '6'),
       ('6', '6'),
       ('4', '7'),
       ('5', '7'),
       ('6', '7'),
       ('4', '8'),
       ('5', '8'),
       ('6', '8');