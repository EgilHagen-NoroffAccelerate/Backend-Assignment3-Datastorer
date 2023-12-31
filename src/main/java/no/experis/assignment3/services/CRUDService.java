package no.experis.assignment3.services;

import java.util.Collection;

/**
 * Service interface for managing CRUD entities.
 */
public interface CRUDService<T, ID> {
    // Generic CRUD
    T findById(ID id);

    Collection<T> findAll();

    T add(T entity);

    T update(T entity);

    void deleteById(ID id);
}

