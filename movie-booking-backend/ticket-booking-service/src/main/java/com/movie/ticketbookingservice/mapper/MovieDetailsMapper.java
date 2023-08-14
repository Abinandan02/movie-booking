package com.movie.ticketbookingservice.mapper;

import com.movie.ticketbookingservice.dto.Movie;
import com.movie.ticketbookingservice.model.MovieDetails;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieDetailsMapper {

    private final ModelMapper mapper;

    public Movie map(MovieDetails movieDetails) {
        return mapper.map(movieDetails, Movie.class);
    }

    public MovieDetails mapTo(Movie movie) {
        return mapper.map(movie, MovieDetails.class);
    }
}
