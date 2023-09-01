package no.experis.assignment3.services.character;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.services.CRUDService;

import java.util.Collection;

public interface CharacterService extends CRUDService<Character, Integer> {
    Collection<Character> findCharacterByName(String name);

    Collection<Movie> getMovies(int characterId);

    void updateMovie(int characterId, int[] movies);

    Collection<Character> findAllCharactersInMovie(int id);

    Collection<Character> findAllCharactersInFranchise(int id);
}