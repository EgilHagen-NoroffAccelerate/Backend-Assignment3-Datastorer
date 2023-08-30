package no.experis.assignment3.models.dto.movie;


import lombok.Getter;
import lombok.Setter;
import no.experis.assignment3.models.dto.character.CharacterDTO;
import no.experis.assignment3.models.dto.franchise.FranchiseDTO;

import java.util.Set;

@Getter
@Setter
public class MovieDTO {
    private int id;
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    private String poster;
    private String trailer;
    private FranchiseDTO franchise;
    private Set<CharacterDTO> characters;
}
