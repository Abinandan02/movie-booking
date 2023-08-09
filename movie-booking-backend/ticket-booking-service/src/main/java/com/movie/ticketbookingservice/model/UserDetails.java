package com.movie.ticketbookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
public class UserDetails {


    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    private String phoneNumber;

    private String email;

    private String password;

    /*@OneToMany(mappedBy = "userDetails")
    private List<Token> tokens;*/
}
