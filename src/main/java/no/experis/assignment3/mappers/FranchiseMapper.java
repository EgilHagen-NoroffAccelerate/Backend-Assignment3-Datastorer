package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.franchise.FranchiseDTO;
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
    public abstract Franchise franchiseDTOToFranchise(FranchiseDTO dto);

    @Named("moviesToIds")
    Set<Integer> mapMoviesToIds(Set<Movie> source) {
        if (source == null)
            return null;
        return source.stream()
                .map(s -> s.getId()).collect(Collectors.toSet());
    }

    @Named("movieIdsToMovies")
    Set<Movie> mapIdsToMovies(Set<Integer> id) {
        return id.stream()
                .map(i -> movieService.findById(i))
                .collect(Collectors.toSet());
    }
}
