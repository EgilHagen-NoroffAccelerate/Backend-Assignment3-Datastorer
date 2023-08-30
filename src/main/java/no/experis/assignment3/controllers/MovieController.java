package no.experis.assignment3.controllers;

import no.experis.assignment3.services.movie.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/projects")
public class MovieController {

    private final MovieService movieService;
    //private final MovieMapper movieMapper;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

   /* @GetMapping
    public ResponseEntity findAll() {

        return ResponseEntity.ok(movieMapper.projectToProjectSimpleDTO(
                movieService.findAll()));
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(
                movieMapper.projectToProjectSimpleDTO(
                        movieService.findById(id)
                ));
    }*/
}

