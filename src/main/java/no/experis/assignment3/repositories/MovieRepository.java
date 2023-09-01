package no.experis.assignment3.repositories;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query(value = "SELECT * FROM movie WHERE title LIKE %?%",
            nativeQuery = true)
    Optional<List<Movie>> findByTitle(String title);

    Collection<Movie> findByFranchise(Franchise franchise);

    @Query(value = "SELECT * FROM Movie WHERE Movie.franchise_id = ?1", nativeQuery = true)
    Collection<Movie> findMoviesByFranchiseId(int id);

}
