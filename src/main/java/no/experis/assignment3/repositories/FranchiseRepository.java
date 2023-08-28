package no.experis.assignment3.repositories;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
