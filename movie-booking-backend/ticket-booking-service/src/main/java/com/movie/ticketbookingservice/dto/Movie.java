package com.movie.ticketbookingservice.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
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
