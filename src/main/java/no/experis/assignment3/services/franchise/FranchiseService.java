package no.experis.assignment3.services.franchise;


import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.services.CRUDService;

import java.util.List;


/**
 * Service interface for managing Franchise entities.
 */
public interface FranchiseService extends CRUDService<Franchise, Integer> {

    Franchise updateMovieInFranchise(List<Integer> movieId, int id);
}