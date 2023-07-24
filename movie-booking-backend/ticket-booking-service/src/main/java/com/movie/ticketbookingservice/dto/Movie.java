package com.movie.ticketbookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {

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
