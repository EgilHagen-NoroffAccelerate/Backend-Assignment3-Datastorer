package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.character.CharacterDTO;
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

@Mapper(componentModel = "spring")
public abstract class MovieMapper {

    @Autowired
    protected CharacterService characterService;
    @Autowired
    protected FranchiseService franchiseService;

    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "charactersToIds")
    public abstract MovieDTO movieToMovieDTO(Movie movie);

    public abstract Collection<MovieDTO> movieToMovieDTO(Collection<Movie> movie);

    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "franchiseIdToFranchise")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "characterIdsToCharacters")
    public abstract Movie movieDTOToMovie(MovieDTO dto);

    @Named("franchiseIdToFranchise")
    Franchise mapIdToFranchise(int id) {
        return franchiseService.findById(id);
    }

    @Named("characterIdsToCharacters")
    Set<Character> mapIdsToCharacters(Set<Integer> id) {
        return id.stream()
                .map( i -> characterService.findById(i))
                .collect(Collectors.toSet());
    }

    @Named("charactersToIds")
    Set<Integer> mapCharactersToIds(Set<Character> source) {
        if(source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }
}