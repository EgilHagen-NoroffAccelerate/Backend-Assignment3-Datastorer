package no.experis.assignment3.services.movie;

import jakarta.transaction.Transactional;
import no.experis.assignment3.exceptions.MovieNotFoundException;
import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.repositories.FranchiseRepository;
import no.experis.assignment3.repositories.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final Logger logger = LoggerFactory.getLogger(MovieServiceImpl.class);
    private final MovieRepository movieRepository;
    private final FranchiseRepository franchiseRepository;

    public MovieServiceImpl(MovieRepository movieRepository, FranchiseRepository franchiseRepository) {
        this.movieRepository = movieRepository;
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Movie findById(Integer id) {
        return movieRepository
                .findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Override
    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public Movie update(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Collection<Movie> findMoviesByFranchise(Franchise franchise) {
        return movieRepository.findByFranchise(franchise);
    }



    /*@Override
    public void addMoviesToFranchise(Franchise franchise, List<Movie> movies) {
        for (Movie movie : movies) {
            movie.setFranchise(franchise);
            movieRepository.save(movie);
        }
    }*/

    @Override
    @Transactional
    public Movie updateCharacterInMovie(List<Integer> characterId, int id) {
        Movie movie = movieRepository.findById(id).get();
        movie.updateCharactersToMovie(characterId);
        return movieRepository.save(movie);
    }

}






