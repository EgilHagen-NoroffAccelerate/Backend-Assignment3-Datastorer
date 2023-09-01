package no.experis.assignment3.services.franchise;


import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.services.CRUDService;

import java.util.Collection;


public interface FranchiseService extends CRUDService<Franchise, Integer> {

    Collection<Franchise> findFranchiseByName(String name);

    Collection<Movie> getMoviesInFranchise(int franchiseID);


}
