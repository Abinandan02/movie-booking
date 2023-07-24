package com.movie.ticketbookingservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Admin {

    private Long adminId;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String gender;

    private String address;

    private String phoneNumber;
}
