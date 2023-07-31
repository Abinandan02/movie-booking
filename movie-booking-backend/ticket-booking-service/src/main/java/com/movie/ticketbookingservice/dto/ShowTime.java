package com.movie.ticketbookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class ShowTime {

    private Long showId;

    private String movieId;

    private Date startTime;

    private Date endTime;

    private String theater;

    private String seats;

}
