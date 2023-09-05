package no.experis.assignment3.services.character;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.services.CRUDService;

import java.util.Collection;

/**
 * Service interface for managing Character entities.
 */
public interface CharacterService extends CRUDService<Character, Integer> {

    /**
     * Update the movies associated with a character.
     *
     * @param characterId The ID of the character to update.
     * @param movies      An array of movie IDs to associate with the character.
     */
    void updateMovie(int characterId, int[] movies);

    /**
     * Retrieve a collection of characters appearing in a specific movie.
     *
     * @param id The ID of the movie.
     * @return A collection of Character objects.
     */
    Collection<Character> findAllCharactersInAMovie(int id);

    /**
     * Retrieve a collection of characters appearing in a specific franchise.
     *
     * @param id The ID of the franchise.
     * @return A collection of Character objects.
     */
    Collection<Character> findAllCharactersInAFranchise(int id);
}
