package no.experis.assignment3.models.dto.character;

import lombok.Getter;
import lombok.Setter;
import no.experis.assignment3.models.Movie;

import java.util.Set;

@Getter
@Setter
public class CharacterDTO {
    private int id;
    private String name;
    private String alias;
    private String gender;
    private String photo;
    private Set<Movie> movies;
}
