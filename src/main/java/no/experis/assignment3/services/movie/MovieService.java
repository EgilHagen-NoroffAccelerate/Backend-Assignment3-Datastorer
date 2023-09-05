package no.experis.assignment3.services.movie;

import no.experis.assignment3.models.Movie;
import no.experis.assignment3.services.CRUDService;

import java.util.List;

/**
 * Service interface for managing Movie entities.
 */
public interface MovieService extends CRUDService<Movie, Integer> {

    Movie updateCharacterInMovie(List<Integer> characterId, int id);
}