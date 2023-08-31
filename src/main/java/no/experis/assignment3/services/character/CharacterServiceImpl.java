package no.experis.assignment3.services.character;

import jakarta.transaction.Transactional;
import no.experis.assignment3.exceptions.CharacterNotFoundException;
import no.experis.assignment3.exceptions.MovieNotFoundException;
import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.repositories.CharacterRepository;
import no.experis.assignment3.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);
    private final CharacterRepository characterRepository;
    private final MovieRepository movieRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository
                .findById(id)
                .orElseThrow(() -> new CharacterNotFoundException(id));
    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (characterRepository.existsById(id)) {
            Character character = characterRepository.findById(id).get();

            for (Movie movie : character.getMovies()) {
                movie.getCharacters().remove(character);
            }

            character.getMovies().clear();

            characterRepository.delete(character);
        }
    }

    @Override
    public Collection<Character> findCharacterByName(String name) {
        return characterRepository.findAllByName(name);
    }

    @Override
    public Collection<Movie> getMovies(int characterId) {
        Character character = characterRepository.findById(characterId)
                .orElseThrow(() -> new CharacterNotFoundException(characterId));

        return character.getMovies();
    }

    @Override
    @Transactional
    public void updateMovie(int characterId, int[] movies) {
        try {
            Character character = characterRepository.findById(characterId)
                    .orElseThrow(() -> new CharacterNotFoundException(characterId));

            Set<Movie> movieList = new HashSet<>();
            for (int id : movies) {
                Movie movie = movieRepository.findById(id)
                        .orElseThrow(() -> new MovieNotFoundException(id));
                if (movie != null) {
                    movieList.add(movie);
                }
            }

            character.setMovies(movieList);
            characterRepository.save(character);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
