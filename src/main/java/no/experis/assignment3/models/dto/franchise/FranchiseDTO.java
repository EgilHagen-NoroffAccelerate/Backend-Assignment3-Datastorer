package no.experis.assignment3.models.dto.franchise;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * DTO Class for transferring objects from franchise class.
 */
@Getter
@Setter
public class FranchiseDTO {
    private int id;
    private String name;
    private Set<Integer> movies;
}
