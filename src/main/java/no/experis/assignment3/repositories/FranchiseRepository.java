package no.experis.assignment3.repositories;

import no.experis.assignment3.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Franchise entities.
 */
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {

}
