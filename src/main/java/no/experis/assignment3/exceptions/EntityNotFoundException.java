package no.experis.assignment3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception to indicate that an entity is not found.
 * This exception corresponds to an HTTP 404 (Not Found) status.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    /**
     * Constructs a new EntityNotFoundException with the specified message.
     *
     * @param message A message describing the entity not found.
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
