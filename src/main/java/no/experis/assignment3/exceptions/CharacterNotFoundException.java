package no.experis.assignment3.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class CharacterNotFoundException extends EntityNotFoundException {
    public CharacterNotFoundException(int id) {
        super("Character does not exist with ID: " + id);
    }
}
