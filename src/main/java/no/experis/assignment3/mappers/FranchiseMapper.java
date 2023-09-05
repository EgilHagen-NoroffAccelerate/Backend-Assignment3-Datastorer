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

/**
 * Mapper class for converting between Franchise and FranchiseDTO objects.
 */
@Mapper(componentModel = "spring")
public abstract class FranchiseMapper {

    @Autowired
    protected MovieService movieService;

    /**
     * Maps a Franchise object to a FranchiseDTO object.
     *
     * @param franchise The Franchise object to be mapped.
     * @return A FranchiseDTO object.
     */
    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);

    /**
     * Maps a collection of Franchise objects to a collection of FranchiseDTO objects.
     *
     * @param franchises The collection of Franchise objects to be mapped.
     * @return A collection of FranchiseDTO objects.
     */
    public abstract Collection<FranchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> franchises);

    /**
     * Maps a FranchiseDTO object to a Franchise object.
     *
     * @param dto The FranchiseDTO object to be mapped.
     * @return A Franchise object.
     */
    @Mapping(target = "movies", source = "movies", qualifiedByName = "movieIdsToMovies")
    public abstract Franchise franchiseDTOToFranchise(FranchiseDTO dto);

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
