package com.movie.ticketbookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "show_details")
public class ShowTimeDetails {

    @Id
    @GeneratedValue
    private Long showId;

    private String movieId;

    private Date startTime;

    private Date endTime;

    private String theater;

    private String seats;

}
