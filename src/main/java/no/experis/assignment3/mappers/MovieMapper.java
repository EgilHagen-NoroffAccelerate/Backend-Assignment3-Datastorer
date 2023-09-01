package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.character.CharacterDTO;
import no.experis.assignment3.models.dto.movie.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "characters", source = "characters")
    MovieDTO movieToMovieDTO(Movie movie);
    Collection<MovieDTO> movieToMovieDTO(Collection<Movie> movies);

    @Named(value = "franchiseToFranchiseId")
    default Set<Integer> map(Set<Franchise> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}

