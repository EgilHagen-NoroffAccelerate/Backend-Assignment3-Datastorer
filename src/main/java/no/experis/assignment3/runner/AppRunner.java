package no.experis.assignment3.runner;

import no.experis.assignment3.services.character.CharacterServiceImpl;
import no.experis.assignment3.services.franchise.FranchiseServiceImpl;
import no.experis.assignment3.services.movie.MovieServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AppRunner implements ApplicationRunner {

    private final CharacterServiceImpl characterService;
    private final MovieServiceImpl movieService;

    private final FranchiseServiceImpl franchiseService;

    public AppRunner(CharacterServiceImpl characterService, MovieServiceImpl movieService, FranchiseServiceImpl franchiseService) {
        this.characterService = characterService;
        this.movieService = movieService;
        this.franchiseService = franchiseService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 6);
        //movieService.updateCharacterInMovie(list, 4);
        franchiseService.updateMovieInFranchise(list, 2);
        movieService.updateCharacterInMovie(list, 2);
        // movieService.addMoviesToFranchise("NOROFF", list);

        //TODO
        //Check if franchiseservice and movieservice is functional with delete and add and update.
        //add moviecontroller and franchisecontroller with update, delete, add and find all
    }
}
