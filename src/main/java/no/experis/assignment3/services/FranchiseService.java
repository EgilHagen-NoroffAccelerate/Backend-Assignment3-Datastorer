package no.experis.assignment3.services;

import no.experis.assignment3.repositories.FranchiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FranchiseService {

    private final FranchiseRepository franchiseRepository;

    @Autowired
    public FranchiseService(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }
}
