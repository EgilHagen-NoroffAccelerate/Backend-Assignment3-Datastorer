package no.experis.assignment3.mappers;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.franchise.FranchiseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

    @Mapping(target = "movies", source = "movies")
    FranchiseDTO franchiseToFranchiseDTO(Franchise franchise);

    Collection<FranchiseDTO> franchiseToFranchiseDTO(Collection<Franchise> franchises);

    @Named("moviesToIds")
    default Set<Integer> moviesToIds(Set<Movie> value) {
        if (value == null)
            return null;
        return value.stream()
                .map(s -> s.getId())
                .collect(Collectors.toSet());
    }
}
