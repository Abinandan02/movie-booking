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
@Table(name = "payment_details")

public class PaymentDetails {

    @Id
    @GeneratedValue
    private Long paymentId;

    private String cardholderName;

    private Long cardNumber;

    private Date expiryDate;

    private Long cvv;
}
