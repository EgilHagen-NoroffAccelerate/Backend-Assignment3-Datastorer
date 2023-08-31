package no.experis.assignment3.runner;

import no.experis.assignment3.services.character.CharacterServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

    private final CharacterServiceImpl characterService;

    public AppRunner(CharacterServiceImpl characterService) {
        this.characterService = characterService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // characterService.getMovies(1).forEach(System.out::println);
        //characterService.findAll().forEach(System.out::println);
        // characterService.updateMovie(1, new int[]{6, 3, 1});
        // characterService.getMovies(1).forEach(System.out::println);
        //characterService.deleteById(1);
        System.out.println(characterService.findById(1));
        characterService.deleteById(1);
        System.out.println(characterService.findById(1));
    }
}
