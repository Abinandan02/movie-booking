package com.movie.ticketbookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class Payment {

    private Long paymentId;

    private String cardholderName;

    private Long cardNumber;

    private Date expiryDate;

    private Long cvv;
}
