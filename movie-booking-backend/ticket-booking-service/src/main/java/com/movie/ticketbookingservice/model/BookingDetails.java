package com.movie.ticketbookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
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
