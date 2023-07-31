package com.movie.ticketbookingservice.service;

import com.movie.ticketbookingservice.dto.User;
import com.movie.ticketbookingservice.exception.NoSuchElementFoundException;

public interface UserService {
    User getUserDetails(Long id) throws NoSuchElementFoundException;
}
