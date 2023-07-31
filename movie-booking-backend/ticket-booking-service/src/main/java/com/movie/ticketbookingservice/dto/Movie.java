package com.movie.ticketbookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
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
