package no.experis.assignment3.runner;

import no.experis.assignment3.repositories.CharacterRepository;
import no.experis.assignment3.repositories.MovieRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    private final CharacterRepository characterRepository;
    private final MovieRepository movieRepository;

    public AppRunner(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(movieRepository
                .findByTitle("Tage")
                );

    }
}
