package com.movie.ticketbookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "admin_user")
public class AdminUser {

    @Id
    @GeneratedValue
    private Long adminId;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String gender;

    private String address;

    private String phoneNumber;
}
