package no.experis.assignment3.exceptions;

public class MovieNotFoundException extends EntityNotFoundException {

    public MovieNotFoundException (int id) {
        super("Movie does not exist with ID: " + id);
    }
}
