package com.movie.ticketbookingservice.adapter;

import com.movie.ticketbookingservice.dto.Movie;
import com.movie.ticketbookingservice.mapper.MovieDetailsMapper;
import com.movie.ticketbookingservice.model.MovieDetails;
import com.movie.ticketbookingservice.repository.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieBookingServiceImplTest {

    @InjectMocks
    MovieBookingServiceImpl movieBookingService;

    @Mock
    MovieRepository movieRepository;

    @Mock
    MovieDetailsMapper movieDetailsMapper;

    @Test
    void testSaveShouldSaveNewMovieDetailsWhenProvidedMovie() {
        Movie movie = Movie.builder()
                .movieId(2L)
                .director("ABC")
                .cast("sss")
                .duration("2 Hour")
                .genre("action")
                .image("sssssss")
                .title("new")
                .build();

        String result = movieBookingService.saveNewMovieDetails(movie);
        Assertions.assertEquals("Success", result);
    }

    @Test
    void testsaveShouldShowFailureWhenThrowException() {
        Movie movie = Movie.builder()
                .movieId(2L)
                .director("ABC")
                .cast("sss")
                .duration("2 Hour")
                .genre("action")
                .image("sssssss")
                .title("new")
                .build();
        //when
        when(movieRepository.save(any())).thenThrow(new RuntimeException());
        //then
        String result = movieBookingService.saveNewMovieDetails(movie);
        Assertions.assertEquals("Failure", result);
    }

    @Test
    void testShouldFindAllMovies() {
        MovieDetails movieDetails = new MovieDetails();
        movieDetails.setMovieId(2L);
        movieDetails.setDirector("ABC");
        movieDetails.setMovieCast("sss");
        movieDetails.setDuration("2 Hour");
        movieDetails.setGenre("action");
        movieDetails.setImage("sssssss");
        movieDetails.setTitle("new");
        Movie movie = Movie.builder()
                .movieId(2L)
                .director("ABC")
                .cast("sss")
                .duration("2 Hour")
                .genre("action")
                .image("sssssss")
                .title("new")
                .build();
        //when
        when(movieRepository.findAll()).thenReturn(Collections.singletonList(movieDetails));
        when(movieDetailsMapper.map(movieDetails)).thenReturn(movie);
        //then
        List<Movie> movieList = movieBookingService.findAllNonExpiredMovies();
        Assertions.assertEquals(1, movieList.size());
        Assertions.assertEquals(2L, movieList.get(0).getMovieId());
        Assertions.assertEquals("ABC", movieList.get(0).getDirector());
        Assertions.assertEquals("sss", movieList.get(0).getCast());
        Assertions.assertEquals("2 Hour", movieList.get(0).getDuration());
        Assertions.assertEquals("action", movieList.get(0).getGenre());
        Assertions.assertEquals("sssssss", movieList.get(0).getImage());
        Assertions.assertEquals("new", movieList.get(0).getTitle());
    }

}
