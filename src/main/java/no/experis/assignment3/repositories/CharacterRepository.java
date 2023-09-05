package no.experis.assignment3.repositories;

import no.experis.assignment3.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * Repository interface for managing Character entities.
 */
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    /**
     * Retrieves a collection of characters appearing in a specific movie.
     *
     * @param id The ID of the movie.
     * @return A collection of Character objects.
     */
    @Query(value = "SELECT * FROM Character " +
            "INNER JOIN movie_character " +
            "ON movie_character.character_id = id " +
            "WHERE movie_character.movie_id= ?1", nativeQuery = true)
    Collection<Character> findAllCharactersInAMovie(int id);

    /**
     * Retrieves a collection of characters appearing in a specific franchise.
     *
     * @param id The ID of the franchise.
     * @return A collection of Character objects.
     */
    @Query(value = "SELECT Character.*, movie_id, franchise_id " +
            "FROM Character " +
            "INNER JOIN movie_character " +
            "ON movie_character.character_id = Character.id " +
            "LEFT JOIN movie as m " +
            "ON movie_character.movie_id = m.id " +
            "WHERE m.franchise_id = ?1", nativeQuery = true)
    Collection<Character> findAllCharactersInAFranchise(int id);
}
