package no.experis.assignment3.repositories;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "SELECT * FROM Movie WHERE Movie.franchise_id = ?1", nativeQuery = true)
    Collection<Movie> findAllMoviesInFranchise(int id);

    @Modifying
    @Query(value = "UPDATE Movie SET franchise_id = NULL WHERE franchise_id = ?1", nativeQuery = true)
    void nullAllMoviesWithCertainFranchiseId(int id);

    @Modifying
    @Query(value = "UPDATE Movie SET franchise_id = ?1 WHERE id = ?2", nativeQuery = true)
    void setFranchiseIdToSpecifiedMovieIds(int fra_id, int movie_id);
}
