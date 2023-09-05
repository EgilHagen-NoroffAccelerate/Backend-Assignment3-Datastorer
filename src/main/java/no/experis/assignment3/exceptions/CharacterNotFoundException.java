package no.experis.assignment3.exceptions;

import jakarta.persistence.EntityNotFoundException;

/**
 * Custom exception to indicate that a character with a specific ID does not exist.
 */
public class CharacterNotFoundException extends EntityNotFoundException {

    /**
     * Constructs a new CharacterNotFoundException with the specified character ID.
     *
     * @param id The ID of the character that was not found.
     */
    public CharacterNotFoundException(int id) {
        super("Character does not exist with ID: " + id);
    }
}
