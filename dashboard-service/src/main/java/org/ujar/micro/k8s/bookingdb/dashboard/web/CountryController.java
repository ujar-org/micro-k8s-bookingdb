package org.ujar.micro.k8s.bookingdb.dashboard.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ujar.boot.starter.restful.web.dto.ErrorResponse;
import org.ujar.boot.starter.restful.web.dto.PageRequestDto;
import org.ujar.micro.k8s.bookingdb.persistence.entity.Country;
import org.ujar.micro.k8s.bookingdb.persistence.repository.CountryRepository;

@RestController
@Tag(name = "Countries controller", description = "API for countries management")
@RequestMapping(name = "/api", produces = "application/vnd.bookingdb.api.v1+json")
@Validated
@RequiredArgsConstructor
public class CountryController {
  private final CountryRepository repository;

  @GetMapping(name = "/countries/{id}", produces = "application/vnd.bookingdb.api.v1+json")
  @Operation(
      description = "Retrieve country by id.",
      responses = {
          @ApiResponse(responseCode = "200",
                       description = "Success"),
          @ApiResponse(responseCode = "500",
                       description = "Internal error",
                       content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
          @ApiResponse(responseCode = "400",
                       description = "Bad request",
                       content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
          @ApiResponse(responseCode = "404",
                       description = "Not found",
                       content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
      })
  public ResponseEntity<Country> findById(@PathVariable final Long id) {
    return ResponseEntity.of(repository.findById(id));
  }

  @GetMapping(name = "/countries", produces = "application/vnd.bookingdb.api.v1+json")
  @Operation(
      description = "Retrieve all countries (with pagination).",
      responses = {
          @ApiResponse(responseCode = "200",
                       description = "Success"),
          @ApiResponse(responseCode = "500",
                       description = "Internal error",
                       content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
          @ApiResponse(responseCode = "400",
                       description = "Bad request",
                       content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
      })
  public ResponseEntity<Page<Country>> findAll(@ParameterObject @Valid PageRequestDto request) {
    final var pageRequest = PageRequest.of(request.getPage(), request.getSize());
    return new ResponseEntity<>(repository.findAll(pageRequest), HttpStatus.OK);
  }
}
