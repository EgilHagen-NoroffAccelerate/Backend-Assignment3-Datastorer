package no.experis.assignment3.mappers;

import no.experis.assignment3.models.dto.movie.MovieDTO;
import no.experis.assignment3.models.Movie;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface MovieMapper {

        @Mapping(target = "description", source = "title")
        @Mapping(target = "character", source = "character.id")
        MovieDTO movieDTO(Movie movie);

        Collection<MovieDTO> projectToProjectSimpleDTO(Collection<Movie> movie);
}


