package no.experis.assignment3.services.franchise;

import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.repositories.FranchiseRepository;

import java.util.Collection;

public class FranchiseServiceImpl implements FranchiseService{

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }
    @Override
    public Franchise findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Franchise> findAll() {
        return null;
    }

    @Override
    public Franchise add(Franchise entity) {
        return null;
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Franchise entity) {

    }
}
