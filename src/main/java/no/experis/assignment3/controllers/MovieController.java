package no.experis.assignment3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.experis.assignment3.exceptions.MovieNotFoundException;
import no.experis.assignment3.mappers.MovieMapper;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.character.CharacterDTO;
import no.experis.assignment3.models.dto.movie.MovieDTO;
import no.experis.assignment3.services.movie.MovieService;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    /**
     * Retrieves a list of all movies.
     *
     * @return ResponseEntity with a list of movies in JSON format.
     */
    @GetMapping
    @Operation(summary = "Gets all movies")
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
        Collection<MovieDTO> movies = movieMapper.movieToMovieDTO(movieService.findAll());

        return ResponseEntity.ok(movies);
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id The ID of the movie to retrieve.
     * @return ResponseEntity with the movie data in JSON format.
     */
    @GetMapping("{id}")
    @Operation(summary = "Movie by a given ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = MovieDTO.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(movieMapper.movieToMovieDTO(movieService.findById(id)));
    }

    /**
     * Adds a new movie to the system.
     *
     * @param entity The movie to add.
     * @return ResponseEntity with the newly created movie data in JSON format.
     * @throws URISyntaxException If there is an issue with the URI.
     */
    @PostMapping
    @Operation(summary = "Adds a movie")
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
    public ResponseEntity add(@RequestBody Movie entity) throws URISyntaxException {
        Movie movie = movieService.add(entity);
        URI uri = URI.create("api/movies/" + movie.getId());
        return ResponseEntity.created(uri).build();
    }

    /**
     * Updates an existing movie.
     *
     * @param movieDTO The updated movie data.
     * @param id       The ID of the movie to update.
     * @return ResponseEntity indicating the success of the update operation.
     */
    @PutMapping("{id}")
    @Operation(summary = "Updates a movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = @Content)
    })
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        if (id != movieDTO.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movieMapper.movieDTOToMovie(movieDTO)
        );
        return ResponseEntity.noContent().build();
    }


    /**
     * Deletes a movie by its ID.
     *
     * @param id The ID of the movie to delete.
     * @return ResponseEntity indicating the success of the delete operation.
     */
    @Operation(summary = "Delete a Movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MovieNotFoundException.class))}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class))})
    })
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates the characters in a specified movie.
     *
     * @param characterId The list of character IDs to update in the movie.
     * @param id          The ID of the movie to update.
     * @return ResponseEntity indicating the success of the update operation.
     */
    @Operation(summary = "Update characters in specified movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class))}),
            @ApiResponse(responseCode = "404",
                    description = "Not found",
                    content = @Content),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class))})
    })
    @PutMapping("characters/movie/{id}")
    public ResponseEntity updateCharacterInMovie(@RequestBody List<Integer> characterId, @PathVariable int id) {
        movieService.updateCharacterInMovie(characterId, id);
        return ResponseEntity.noContent().build();
    }

}



