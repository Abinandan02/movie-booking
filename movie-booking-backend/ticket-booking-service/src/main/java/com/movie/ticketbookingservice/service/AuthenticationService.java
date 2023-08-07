package com.movie.ticketbookingservice.service;

import com.movie.ticketbookingservice.dto.AuthenticationResponse;
import com.movie.ticketbookingservice.dto.LoginRequest;
import com.movie.ticketbookingservice.dto.RegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest registerRequest);

    AuthenticationResponse authenticate(LoginRequest loginRequest);

    void refreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException;
}
