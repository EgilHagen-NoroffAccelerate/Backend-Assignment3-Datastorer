package no.experis.assignment3.services.movie;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.services.CRUDService;

import java.util.Collection;
import java.util.List;

public interface MovieService extends CRUDService<Movie, Integer> {

    Collection<Movie> findAllMoviesInFranchise(int id);

    void addMoviesToFranchise(Franchise franchise, List<Movie> movies);

    //void nullAllMoviesWithCertainFranchiseId(int id);
    //void setFranchiseIdToSpecifiedMovieIds(int fra_id, int movie_id);

    Movie updateCharactersInMovie(List<Integer> idList, int id);

}