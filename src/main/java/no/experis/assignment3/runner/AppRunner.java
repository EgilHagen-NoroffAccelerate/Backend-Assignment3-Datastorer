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

        //TODO
        //Check if franchiseservice and movieservice is functional with delete and add and update.
        //add moviecontroller and franchisecontroller with update, delete, add and find all

    }
}
