package com.movie.ticketbookingservice.service;

import com.movie.ticketbookingservice.dto.UserInfo;
import com.movie.ticketbookingservice.exception.NoSuchElementFoundException;

public interface UserService {
    UserInfo getUserDetails(Long id) throws NoSuchElementFoundException;
}
