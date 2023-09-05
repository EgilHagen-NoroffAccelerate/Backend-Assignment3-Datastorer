package no.experis.assignment3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.experis.assignment3.exceptions.FranchiseNotFoundException;
import no.experis.assignment3.mappers.FranchiseMapper;
import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.dto.franchise.FranchiseDTO;
import no.experis.assignment3.models.dto.movie.MovieDTO;
import no.experis.assignment3.services.franchise.FranchiseService;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;


    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    /**
     * Retrieves a list of all franchises.
     *
     * @return ResponseEntity with a list of franchises in JSON format.
     */
    @GetMapping
    @Operation(summary = "Gets all franchises")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = FranchiseDTO.class))
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findAll() {
        return ResponseEntity.ok(franchiseMapper.franchiseToFranchiseDTO(franchiseService.findAll()));
    }

    /**
     * Retrieves a franchise by ID.
     *
     * @param id The ID of the franchise to retrieve.
     * @return ResponseEntity with the franchise data in JSON format.
     */
    @GetMapping("{id}")
    @Operation(summary = "Franchise by given ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = FranchiseDTO.class))}
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))
            )
    })
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(franchiseMapper.franchiseToFranchiseDTO(franchiseService.findById(id)));
    }

    /**
     * Adds a new franchise to the system.
     *
     * @param entity The franchise to add.
     * @return ResponseEntity with the newly created franchise data in JSON format.
     * @throws URISyntaxException If there is an issue with the URI.
     */
    @PostMapping
    @Operation(summary = "Adds")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FranchiseDTO.class))
            ),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class))})
    })
    public ResponseEntity add(@RequestBody Franchise entity) throws URISyntaxException {
        Franchise franchise = franchiseService.add(entity);
        URI uri = URI.create("api/franchises/" + franchise.getId());
        return ResponseEntity.created(uri).build();
    }

    /**
     * Updates an existing franchise.
     *
     * @param franchiseDTO The updated franchise data.
     * @param id           The ID of the franchise to update.
     * @return ResponseEntity indicating the success of the update operation.
     */
    @PutMapping("{id}")
    @Operation(summary = "Updates a franchise")
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
    public ResponseEntity update(@RequestBody FranchiseDTO franchiseDTO, @PathVariable int id) {
        if (id != franchiseDTO.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchiseMapper.franchiseDTOToFranchise(franchiseDTO));
        return ResponseEntity.noContent().build();
    }

    /**
     * Deletes a franchise by its ID.
     *
     * @param id The ID of the franchise to delete.
     * @return ResponseEntity indicating the success of the delete operation.
     */
    @Operation(summary = "Delete a Franchise")
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
                            schema = @Schema(implementation = FranchiseNotFoundException.class))}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorAttributeOptions.class))})
    })
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    /**
     * Updates the movies in a specified franchise.
     *
     * @param movieId The list of movie IDs to update in the franchise.
     * @param id      The ID of the franchise to update.
     * @return ResponseEntity indicating the success of the update operation.
     */
    @Operation(summary = "Update movies in Franchise")
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
    @PutMapping("franchise/{id}")
    public ResponseEntity updateMovieInFranchise(@RequestBody List<Integer> movieId, @PathVariable int id) {
        franchiseService.updateMovieInFranchise(movieId, id);
        return ResponseEntity.noContent().build();
    }
}
