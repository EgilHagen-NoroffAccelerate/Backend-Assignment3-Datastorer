package no.experis.assignment3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.experis.assignment3.mappers.MovieMapper;
import no.experis.assignment3.models.Movie;
import no.experis.assignment3.models.dto.movie.MovieDTO;
import no.experis.assignment3.services.movie.MovieService;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;


@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping
    @Operation(summary = "Gets all movies")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = MovieDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll() {
        Collection<MovieDTO> movies = movieMapper.movieToMovieDTO(movieService.findAll());

        return ResponseEntity.ok(movies);
    }


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

    @PostMapping
    @Operation(summary = "Adds")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content
            )
    })
    public ResponseEntity add(@RequestBody Movie entity) throws URISyntaxException {
        Movie movie = movieService.add(entity);
        URI uri = URI.create("api/movies/" + movie.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates a movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Movie successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Movie not found with supplied ID",
                    content = @Content)
    })
    public ResponseEntity update(@RequestBody MovieDTO movieDTO, @PathVariable int id) {
        if (id != movieDTO.getId())
            return ResponseEntity.badRequest().build();
        movieService.update(movieMapper.movieDTOToMovie(movieDTO)
        );
        return ResponseEntity.noContent().build();
    }
}



