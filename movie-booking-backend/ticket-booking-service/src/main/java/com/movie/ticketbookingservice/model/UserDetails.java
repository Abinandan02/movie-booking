package com.movie.ticketbookingservice.model;

import com.movie.ticketbookingservice.token.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @OneToMany(mappedBy = "userDetails")
    private List<Token> tokens;
}
