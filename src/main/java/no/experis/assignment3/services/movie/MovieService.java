package no.experis.assignment3.services.movie;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.services.CRUDService;

import java.util.Collection;
import java.util.List;

public interface MovieService extends CRUDService<Movie, Integer> {

    Collection<Movie> findMoviesByFranchise(Franchise franchise);

    //void addMoviesToFranchise(Franchise franchise, List<Movie> movies);

    Movie updateCharacterInMovie(List<Integer> characterId, int id);
}