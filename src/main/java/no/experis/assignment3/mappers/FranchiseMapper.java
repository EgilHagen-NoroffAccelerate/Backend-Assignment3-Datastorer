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
public abstract class FranchiseMapper {
    @Autowired
    protected MovieService movieService;

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);

    public abstract Collection<FranchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> franchises);

    @Mapping(target = "movies", source = "movies", qualifiedByName = "movieIdsToMovies")
    public abstract Franchise franchiseDtoToFranchise(FranchiseDTO dto);

    @Named("moviesToIds")
    Set<Integer> mapMoviesToIds(Set<Movie> value) {
        if(value == null)
            return null;
        return value.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }

    @Named("movieIdsToMovies")
    Set<Movie> map(Set<Integer> id) {
        return id.stream()
                .map( i -> movieService.findById(i))
                .collect(Collectors.toSet());
    }
}