package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.movie.MovieDTO;
import no.experis.assignment3.services.character.CharacterService;
import no.experis.assignment3.services.franchise.FranchiseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper class for converting between Movie and MovieDTO objects.
 */
@Mapper(componentModel = "spring")
public abstract class MovieMapper {

    @Autowired
    protected CharacterService characterService;
    @Autowired
    protected FranchiseService franchiseService;

    /**
     * Maps a Movie object to a MovieDTO object.
     *
     * @param movie The Movie object to be mapped.
     * @return A MovieDTO object.
     */
    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract MovieDTO movieToMovieDTO(Movie movie);

    /**
     * Maps a collection of Movie objects to a collection of MovieDTO objects.
     *
     * @param movies The collection of Movie objects to be mapped.
     * @return A collection of MovieDTO objects.
     */
    public abstract Collection<MovieDTO> movieToMovieDTO(Collection<Movie> movies);

    /**
     * Maps a MovieDTO object to a Movie object.
     *
     * @param dto The MovieDTO object to be mapped.
     * @return A Movie object.
     */
    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "franchiseIdToFranchise")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "characterIdsToCharacters")
    public abstract Movie movieDTOToMovie(MovieDTO dto);

    /**
     * Maps a franchise ID to a Franchise object.
     *
     * @param id The ID of the franchise to be mapped.
     * @return A Franchise object.
     */
    @Named("franchiseIdToFranchise")
    Franchise mapIdToFranchise(int id) {
        return franchiseService.findById(id);
    }

    /**
     * Maps a Set of character IDs to a Set of Character objects.
     *
     * @param id The Set of character IDs to be mapped.
     * @return A Set of Character objects.
     */
    @Named("characterIdsToCharacters")
    Set<Character> mapIdsToCharacters(Set<Integer> id) {
        return id.stream()
                .map(i -> characterService.findById(i))
                .collect(Collectors.toSet());
    }

    /**
     * Maps a Set of Character objects to a Set of character IDs.
     *
     * @param value The Set of Character objects to be mapped.
     * @return A Set of character IDs.
     */
    @Named("charactersToIds")
    Set<Integer> mapCharactersToIds(Set<Character> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
}
