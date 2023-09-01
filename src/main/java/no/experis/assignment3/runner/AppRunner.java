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
        System.out.println(characterService.findById(7));
        //characterService.deleteById(1);

        //TODO
        //Check if franchiseservice and movieservice is functional with delete and add and update.
        //update mappers
        //add movielistDTO and characterlistDTO
        //add moviecontroller and franchisecontroller with update, delete, add and find all
        //running application -  http://localhost:8080/api/characters - shows output of two characters infinitely.
        //try to find a way to display all the characters just once, and if set http://localhost:8080/api/characters/(id),
        //should display the right character to the id given.
        //documentation using Swagger
        //Set deletecharacter on the post api to null
        //

    }
}
