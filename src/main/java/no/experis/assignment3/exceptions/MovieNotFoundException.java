package no.experis.assignment3.exceptions;

/**
 * Custom exception to indicate that a movie with a specific ID does not exist.
 * This exception is a subtype of EntityNotFoundException.
 */
public class MovieNotFoundException extends EntityNotFoundException {

    /**
     * Constructs a new MovieNotFoundException with the specified movie ID.
     *
     * @param id The ID of the movie that was not found.
     */
    public MovieNotFoundException(int id) {
        super("Movie does not exist with ID: " + id);
    }
}
