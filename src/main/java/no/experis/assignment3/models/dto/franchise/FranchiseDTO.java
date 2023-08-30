package no.experis.assignment3.models.dto.franchise;

import lombok.Getter;
import lombok.Setter;
import no.experis.assignment3.models.dto.movie.MovieDTO;

import java.util.Set;

@Getter
@Setter
public class FranchiseDTO {
    private int id;
    private String name;
    private Set<MovieDTO> movies;
}
