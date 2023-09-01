package no.experis.assignment3.repositories;

import no.experis.assignment3.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query(value = "SELECT * FROM character WHERE name LIKE %?%",
            nativeQuery = true)
    Collection<Character> findAllByName(String name);

    @Query(value = "SELECT * FROM Character INNER JOIN movie_character ON movie_character.character_id = id WHERE movie_character.movie_id= ?1", nativeQuery = true)
    Collection<Character> findAllCharactersInMovie(int id);

    @Query(value = "SELECT * FROM Character INNER JOIN movie_character ON movie_character.character_id = id INNER JOIN movie ON movie.id = movie_character.movie_id WHERE movie.franchise_id = ?1", nativeQuery = true)
    Collection<Character> findAllCharactersInFranchise(int id);

}
