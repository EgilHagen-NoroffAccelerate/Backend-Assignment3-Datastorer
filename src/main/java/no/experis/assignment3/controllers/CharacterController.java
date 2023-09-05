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
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/api/characters")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    /**
     * Retrieves a list of all characters.
     *
     * @return ResponseEntity with a list of characters in JSON format.
     */
    @GetMapping
    @Operation(summary = "Gets all characters")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content =
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))
            ),
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

    /**
     * Retrieves a character by their ID.
     *
     * @param id The ID of the character to retrieve.
     * @return ResponseEntity with the character data in JSON format.
     */
    @GetMapping("{id}")
    @Operation(summary = "Gets a character by their ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class))}
            ),
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

    /**
     * Adds a new character to the system.
     *
     * @param entity The character to add.
     * @return ResponseEntity with the newly created character data in JSON format.
     * @throws URISyntaxException If there is an issue with the URI.
     */
    @PostMapping
    @Operation(summary = "Adds a character")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity add(@RequestBody Character entity) throws URISyntaxException {
        Character character = characterService.add(entity);
        URI uri = URI.create("api/characters" + character.getId());
        return ResponseEntity.created(uri).build();
    }

    /**
     * Updates an existing character.
     *
     * @param characterDTO The updated character data.
     * @param id           The ID of the character to update.
     * @return ResponseEntity indicating the success of the update operation.
     */
    @PutMapping("{id}")
    @Operation(summary = "Updates a character")
    @ApiResponses(value = {
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
    public ResponseEntity update(@RequestBody CharacterDTO characterDTO, @PathVariable int id) {
        if (id != characterDTO.getId())
            return ResponseEntity.badRequest().build();
        Character updatedChar = characterMapper.characterDTOToCharacter(characterDTO);
        characterService.update(updatedChar);
        return ResponseEntity.noContent().build();
    }

    /**
     * Retrieves characters in a specific movie.
     *
     * @param id The ID of the movie.
     * @return ResponseEntity with a list of characters in the movie in JSON format.
     */
    @Operation(summary = "Get characters in a movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class))
                    }
            ),
            @ApiResponse(responseCode = "404",
                    description = "Characters do not exist with supplied movie ID",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))})
    })
    @GetMapping("movie/{id}")
    public ResponseEntity findAllCharactersInAMovie(@PathVariable int id) {
        return ResponseEntity.ok(characterMapper.characterToCharacterDTO(characterService.findAllCharactersInAMovie(id)));
    }


    /**
     * Retrieves characters in a specific franchise.
     *
     * @param id The ID of the franchise.
     * @return ResponseEntity with a list of characters in the franchise in JSON format.
     */
    @Operation(summary = "Get characters in a franchise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class))
                    }
            ),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
                    })
    })
    @GetMapping("franchise/{id}")
    public ResponseEntity findAllCharactersInAFranchise(@PathVariable int id) {
        return ResponseEntity.ok(characterMapper.characterToCharacterDTO(characterService.findAllCharactersInAFranchise(id)));
    }


    /**
     * Deletes a character by their ID.
     *
     * @param id The ID of the character to delete.
     * @return ResponseEntity indicating the success of the delete operation.
     */
    @Operation(summary = "Delete a character")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Character successfully deleted",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Character not found with supplied ID",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class))})
    })
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}




