package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.franchise.FranchiseDTO;
import no.experis.assignment3.models.dto.movie.MovieDTO;
import no.experis.assignment3.services.movie.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {


    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);
    Collection<FranchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> franchises);

    @Named(value = "movieToMovieId")
        default Set<Integer> map(Set<Movie> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}