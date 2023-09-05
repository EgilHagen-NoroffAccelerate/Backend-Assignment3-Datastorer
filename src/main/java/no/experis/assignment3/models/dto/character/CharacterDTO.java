package no.experis.assignment3.models.dto.character;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * DTO Class for transferring objects from character class.
 */
@Getter
@Setter
public class CharacterDTO {
    private int id;
    private String name;
    private String alias;
    private String gender;
    private String photo;
    private Set<Integer> movies;
}
