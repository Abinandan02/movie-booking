package com.movie.ticketbookingservice.mapper;

import com.movie.ticketbookingservice.dto.UserInfo;
import com.movie.ticketbookingservice.model.UserDetails;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailMapper {

    private final ModelMapper mapper;

    public UserInfo map(UserDetails userDetails) {
        return mapper.map(userDetails, UserInfo.class);
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
