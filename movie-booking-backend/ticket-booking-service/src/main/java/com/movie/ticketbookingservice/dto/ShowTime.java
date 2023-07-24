package com.movie.ticketbookingservice.dto;

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
public class ShowTime {

    private Long showId;

    private String movieId;

    private Date startTime;

    private Date endTime;

    private String theater;

    private String seats;

}
