package no.experis.assignment3.services.franchise;

import jakarta.transaction.Transactional;
import no.experis.assignment3.exceptions.FranchiseNotFoundException;
import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.repositories.FranchiseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    private final Logger logger = LoggerFactory.getLogger(FranchiseServiceImpl.class);
    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository
                .findById(id)
                .orElseThrow(() -> new FranchiseNotFoundException(id));
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        franchiseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Franchise updateMovieInFranchise(List<Integer> movieId, int id) {
        Franchise franchise = franchiseRepository.findById(id).get();
        franchise.updateMovieToFranchise(movieId);
        return franchiseRepository.save(franchise);
    }
}
