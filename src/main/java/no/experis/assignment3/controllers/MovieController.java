package no.experis.assignment3.controllers;

import no.experis.assignment3.mappers.MovieMapper;
import no.experis.assignment3.services.movie.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/projects")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    /*
    @GetMapping
    @Operation(summary = "Gets all the movies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll() {
        return ResponseEntity.ok(
                movieMapper.movieToMovieDTO(

                )
        );
    }*/

}

