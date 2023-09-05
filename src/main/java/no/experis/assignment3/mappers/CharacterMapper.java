package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.character.CharacterDTO;
import no.experis.assignment3.services.movie.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper class for converting between Character and CharacterDTO objects.
 */
@Mapper(componentModel = "spring")
public abstract class CharacterMapper {

    @Autowired
    protected MovieService movieService;

    /**
     * Maps a Character object to a CharacterDTO object.
     *
     * @param character The Character object to be mapped.
     * @return A CharacterDTO object.
     */
    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract CharacterDTO characterToCharacterDTO(Character character);

    /**
     * Maps a CharacterDTO object to a Character object.
     *
     * @param characterDTO The CharacterDTO object to be mapped.
     * @return A Character object.
     */
    @Mapping(target = "movies", source = "movies", qualifiedByName = "movieIdsToMovies")
    public abstract Character characterDTOToCharacter(CharacterDTO characterDTO);

    /**
     * Maps a collection of Character objects to a collection of CharacterDTO objects.
     *
     * @param characters The collection of Character objects to be mapped.
     * @return A collection of CharacterDTO objects.
     */
    public abstract Collection<CharacterDTO> characterToCharacterDTO(Collection<Character> characters);

    /**
     * Maps a Set of Movie objects to a Set of movie IDs.
     *
     * @param source The Set of Movie objects to be mapped.
     * @return A Set of movie IDs.
     */
    @Named("moviesToIds")
    Set<Integer> mapMoviesToIds(Set<Movie> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }

    /**
     * Maps a Set of movie IDs to a Set of Movie objects.
     *
     * @param id The Set of movie IDs to be mapped.
     * @return A Set of Movie objects.
     */
    @Named("movieIdsToMovies")
    Set<Movie> mapIdsToMovies(Set<Integer> id) {
        return id.stream()
                .map(i -> movieService.findById(i))
                .collect(Collectors.toSet());
    }
}
