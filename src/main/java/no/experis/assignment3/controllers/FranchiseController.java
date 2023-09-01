package no.experis.assignment3.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import no.experis.assignment3.mappers.FranchiseMapper;
import no.experis.assignment3.models.Franchise;
import no.experis.assignment3.models.dto.franchise.FranchiseDTO;
import no.experis.assignment3.services.franchise.FranchiseService;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;


    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @GetMapping
    @Operation(summary = "Gets all the franchises")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = FranchiseDTO.class)))
                    }
            )
    })
    public ResponseEntity findAll() {
        return ResponseEntity.ok(franchiseMapper.franchiseToFranchiseDTO(franchiseService.findAll()));
    }

    @GetMapping("{id}")
    @Operation(summary = "Gets a franchise by it's ID")
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
    public ResponseEntity findById(@PathVariable int id) {
        return ResponseEntity.ok(franchiseService.findById(id));
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
    public ResponseEntity add(@RequestBody Franchise franchise) throws URISyntaxException {
        // Add
        //StudentService.add(entity);
        URI uri = new URI("api/franchises/" + 1);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Updates a franchise")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Student successfully updated",
                    content = @Content),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = @Content),
            @ApiResponse(responseCode = "404",
                    description = "Student not found with supplied ID",
                    content = @Content)
    })
    public ResponseEntity update(@RequestBody Franchise franchise, @PathVariable int id){
        if(id != franchise.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(franchise);
        return ResponseEntity.noContent().build();
    }

}
