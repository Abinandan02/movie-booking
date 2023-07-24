package com.movie.ticketbookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Payment {

    private Long paymentId;

    private String cardholderName;

    private Long cardNumber;

    private Date expiryDate;

    private Long cvv;
}
