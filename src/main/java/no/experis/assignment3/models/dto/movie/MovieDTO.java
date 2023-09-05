package no.experis.assignment3.models.dto.movie;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * DTO Class for transferring objects from movie class.
 */
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
    private Set<Integer> characters;
    private int franchise;
}
