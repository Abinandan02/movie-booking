package com.movie.ticketbookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Booking {

    private Long bookingId;

    private Long userId;

    private Date showTime;

    private String seats;

    private String paymentId;

    private Long showId;
}
