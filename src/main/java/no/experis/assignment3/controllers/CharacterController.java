package no.experis.assignment3.controllers;

import no.experis.assignment3.dto.CharacterDTO;
import no.experis.assignment3.services.character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
    public class CharacterController {
        private final CharacterService characterService;

        @Autowired
        public CharacterController(CharacterService characterService) {
            this.characterService = characterService;
        }

        @GetMapping("/{id}")
        public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long id) {
            return ResponseEntity.ok(characterService.findById(id));
        }

        @GetMapping
        public ResponseEntity<List<CharacterDTO>> getAllCharacters() {
            return ResponseEntity.ok(characterService.findAll());
        }

        // Other CRUD operations and related endpoints
    }


