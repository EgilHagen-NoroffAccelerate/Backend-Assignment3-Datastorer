package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.movie.MovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface MovieMapper {


    @Mapping(target = "franchise", source = "franchise.id")
    @Mapping(target = "characters", source = "characters")
    MovieDTO movieToMovieDto(Movie movie);

    Collection<MovieDTO> movieToMovieDto(Collection<Movie> movies);

}


