package no.experis.assignment3.repositories;

import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query(value = "SELECT name, alias, gender, photo FROM character WHERE name LIKE %?%",
            nativeQuery = true)
    Optional<List<Character>> findByNameContaining(String name);

}
