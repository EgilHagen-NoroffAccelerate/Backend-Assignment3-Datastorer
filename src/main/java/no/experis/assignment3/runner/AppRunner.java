package no.experis.assignment3.runner;

import no.experis.assignment3.models.Character;
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

        characterService.findAll().forEach(System.out::println);

        Character newChar = new Character();
        newChar.setName("new character");
        newChar.setAlias("brusjan ny karakter da");
        newChar.setGender("female");
        characterService.add(newChar);
        System.out.println(characterService.findCharacterByName("new character"));
        // characterService.getMovies(1).forEach(System.out::println);

        int[] movieIds = new int[]{3, 1, 6};
        characterService.updateMovie(1, movieIds);
        characterService.getMovies(1).forEach(System.out::println);
        System.out.println(characterService.findById(1));
        //characterService.deleteById(1);


    }
}
