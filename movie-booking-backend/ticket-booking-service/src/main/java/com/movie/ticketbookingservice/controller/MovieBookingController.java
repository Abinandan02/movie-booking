package com.movie.ticketbookingservice.controller;

import com.movie.ticketbookingservice.dto.Movie;
import com.movie.ticketbookingservice.service.MovieBookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class MovieBookingController {

    private final MovieBookingService movieBookingService;

    @PostMapping("/save")
    public ResponseEntity<String> addNewMovieDetails(@Valid @RequestBody Movie movie){
        return ResponseEntity.ok().body(movieBookingService.saveNewMovieDetails(movie));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> retrieveAllMovieDetails() {
        return ResponseEntity.ok().body(movieBookingService.findAllNonExpiredMovies());
    }
}
