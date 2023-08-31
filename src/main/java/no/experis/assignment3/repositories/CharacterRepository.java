package no.experis.assignment3.repositories;

import no.experis.assignment3.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CharacterRepository extends JpaRepository<Character, Integer> {

    @Query(value = "SELECT * FROM character WHERE name LIKE %?%",
            nativeQuery = true)
    Collection<Character> findAllByName(String name);

}
