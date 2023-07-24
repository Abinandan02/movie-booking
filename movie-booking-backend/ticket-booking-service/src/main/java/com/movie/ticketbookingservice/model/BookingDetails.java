package com.movie.ticketbookingservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "booking_details")
public class BookingDetails {

    @Id
    @GeneratedValue
    private Long bookingId;

    private Long userId;

    private Date showTime;

    private String seats;

    private String paymentId;

    private Long showId;
}
