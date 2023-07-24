package com.movie.ticketbookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Booking {

    private Long bookingId;

    private Long userId;

    private Date showTime;

    private String seats;

    private String paymentId;

    private Long showId;
}
