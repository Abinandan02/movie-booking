package com.movie.ticketbookingservice.service;

import com.movie.ticketbookingservice.dto.Movie;
import com.movie.ticketbookingservice.mapper.MovieDetailsMapper;
import com.movie.ticketbookingservice.model.MovieDetails;
import com.movie.ticketbookingservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieBookingServiceImpl implements MovieBookingService{

    private final MovieRepository movieRepository;
    private final MovieDetailsMapper movieDetailsMapper;

    @Override
    public String saveNewMovieDetails(Movie movie) {
        try {
            movieRepository.save(movieDetailsMapper.mapTo(movie));
        } catch (Exception ex) {
            log.error("movie details not saved due to error", ex);
        }
        return "Success";
    }
}
