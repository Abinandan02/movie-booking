package com.movie.ticketbookingservice.mapper;

import com.movie.ticketbookingservice.dto.UserInfo;
import com.movie.ticketbookingservice.model.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailMapper {


    public UserInfo map(UserDetails userDetails) {
        return UserInfo.builder()
                .address(userDetails.getAddress())
                .email(userDetails.getEmail())
                .firstName(userDetails.getFirstName())
                .id(userDetails.getId())
                .gender(userDetails.getGender())
                .lastName(userDetails.getLastName())
                .phoneNumber(userDetails.getPhoneNumber())
                .build();
    }

    public UserDetails mapTo(UserInfo userInfo) {
        return UserDetails.builder()
                .address(userInfo.getAddress())
                .email(userInfo.getEmail())
                .firstName(userInfo.getFirstName())
                .id(userInfo.getId())
                .gender(userInfo.getGender())
                .lastName(userInfo.getLastName())
                .phoneNumber(userInfo.getPhoneNumber())
                .password(userInfo.getPassword())
                .build();
    }
}
