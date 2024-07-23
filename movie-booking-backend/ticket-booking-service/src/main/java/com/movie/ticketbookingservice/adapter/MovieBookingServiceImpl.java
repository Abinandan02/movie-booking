package com.movie.ticketbookingservice.adapter;

import com.movie.ticketbookingservice.dto.Movie;
import com.movie.ticketbookingservice.mapper.MovieDetailsMapper;
import com.movie.ticketbookingservice.repository.MovieRepository;
import com.movie.ticketbookingservice.service.MovieBookingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieBookingServiceImpl implements MovieBookingService {

    private final MovieRepository movieRepository;
    private final MovieDetailsMapper movieDetailsMapper;

    @Override
    public String saveNewMovieDetails(Movie movie) {
        try {
            movieRepository.save(movieDetailsMapper.mapTo(movie));
            log.info("movie details saved for {}", movie);
        } catch (Exception ex) {
            log.error("movie details not saved due to error", ex);
            return "Failure";
        }
        return "Success";
    }

    @Override
    public List<Movie> findAllNonExpiredMovies() {
        return movieRepository.findAll().stream()
                .map(movieDetailsMapper::map)
                .toList();
    }
}
