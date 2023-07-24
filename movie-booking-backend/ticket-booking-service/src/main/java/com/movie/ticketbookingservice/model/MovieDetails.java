package com.movie.ticketbookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "movie_details")
public class MovieDetails {

    @Id
    @GeneratedValue
    private Long movieId;

    private String title;

    private String genre;

    private String director;

    private String cast;

    private String synopsis;

    private String duration;

    private Date releaseDate;

    private String image;
}
