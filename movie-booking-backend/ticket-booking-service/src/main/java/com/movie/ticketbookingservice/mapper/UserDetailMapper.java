package com.movie.ticketbookingservice.mapper;

import com.movie.ticketbookingservice.dto.User;
import com.movie.ticketbookingservice.model.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper {

    public User map(UserDetails userDetails) {
        return User.builder()
                .address(userDetails.getAddress())
                .email(userDetails.getEmail())
                .firstName(userDetails.getFirstName())
                .id(userDetails.getId())
                .gender(userDetails.getGender())
                .lastName(userDetails.getLastName())
                .phoneNumber(userDetails.getPhoneNumber())
                .build();
    }
}
