package com.movie.ticketbookingservice.service;

import com.movie.ticketbookingservice.dto.UserInfo;
import com.movie.ticketbookingservice.exception.NoSuchElementFoundException;
import com.movie.ticketbookingservice.model.UserDetails;

import java.util.List;

public interface UserService {
    UserInfo getUserDetails(Long id) throws NoSuchElementFoundException;
    List<UserInfo> getAllUserDetails();
}
