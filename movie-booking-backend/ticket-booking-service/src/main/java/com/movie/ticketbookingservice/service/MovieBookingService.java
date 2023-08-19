package com.movie.ticketbookingservice.service;

import com.movie.ticketbookingservice.dto.Movie;

import java.util.List;

public interface MovieBookingService {
    String saveNewMovieDetails(Movie movie);

    List<Movie> findAllNonExpiredMovies();
}
