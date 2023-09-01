package no.experis.assignment3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.experis.assignment3.mappers.CharacterMapper;
import no.experis.assignment3.models.Character;
import no.experis.assignment3.models.dto.character.CharacterDTO;
import no.experis.assignment3.services.character.CharacterService;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

//@Autowired
@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @GetMapping
    @Operation(summary = "Gets all the characters")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findAll() {
        return ResponseEntity.ok(characterMapper.characterToCharacterDTO(characterService.findAll()));
    }

    @GetMapping("{id}")
    @Operation(summary = "Gets a character by their ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = CharacterDTO.class))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(characterMapper.characterToCharacterDTO(characterService.findById(id)));
    }

    @PostMapping
    @Operation(summary = "Adds a character")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })
    public ResponseEntity add(@RequestBody CharacterDTO entity) throws URISyntaxException {
        // Add
        //StudentService.add(entity);
        URI uri = new URI("api/characters" + 1);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates a character")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Character successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = @Content)
    })
    /*
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id){
        if(id != characterDTO.getId())
            return ResponseEntity.badRequest().build();
        characterService.update(characterDTO);
        return ResponseEntity.noContent().build();
    }

     */

    @Operation(summary = "Get characters in a movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            })
    })
    @GetMapping("{id}/movies")
    public ResponseEntity<Collection<Character>> findAllCharactersInMovie(@PathVariable int id) {
        return ResponseEntity.ok(characterService.findAllCharactersInMovie(id));
    }

    @PutMapping("{id}/movies")
    public ResponseEntity updateMovies(@PathVariable int id, @RequestBody int[] movieIds) {
        characterService.updateMovie(id, movieIds);
        return ResponseEntity.noContent().build();
    }
}




