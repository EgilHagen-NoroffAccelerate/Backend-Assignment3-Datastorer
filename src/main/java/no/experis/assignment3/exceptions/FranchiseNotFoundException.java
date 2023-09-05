package no.experis.assignment3.exceptions;

/**
 * Custom exception to indicate that a franchise with a specific ID does not exist.
 * This exception is a subtype of EntityNotFoundException.
 */
public class FranchiseNotFoundException extends EntityNotFoundException {

    /**
     * Constructs a new FranchiseNotFoundException with the specified franchise ID.
     *
     * @param id The ID of the franchise that was not found.
     */
    public FranchiseNotFoundException(int id) {
        super("Franchise does not exist with ID: " + id);
    }
}
