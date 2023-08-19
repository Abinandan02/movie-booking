package com.movie.ticketbookingservice.repository;

import com.movie.ticketbookingservice.model.MovieDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieDetails, Long> {
}
