package com.movie.ticketbookingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.ticketbookingservice.dto.AuthenticationResponse;
import com.movie.ticketbookingservice.dto.LoginRequest;
import com.movie.ticketbookingservice.dto.RegisterRequest;
import com.movie.ticketbookingservice.dto.UserInfo;
import com.movie.ticketbookingservice.mapper.UserDetailMapper;
import com.movie.ticketbookingservice.model.UserDetails;
import com.movie.ticketbookingservice.repository.UserRepository;
import com.movie.ticketbookingservice.token.Token;
import com.movie.ticketbookingservice.token.TokenRepository;
import com.movie.ticketbookingservice.token.TokenType;
import com.movie.ticketbookingservice.util.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final UserDetailMapper userDetailMapper;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {
        /*var user = UserInfo.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .build();

        var savedUser = userRepository.save(userDetailMapper.mapTo(user));
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();*/
        // TODO fix this.
        return null;
    }

    @Override
    public AuthenticationResponse authenticate(LoginRequest loginRequest) {
        String jwtToken = null;
        String refreshToken = null;
        try{
            UserDetails userDetails = userRepository.findByEmail(loginRequest.getEmail())
                    .orElseThrow();
            if(userPasswordIsAuthentication(loginRequest, userDetails)){
                var user = userDetailMapper.map(userDetails);
                jwtToken = jwtService.generateToken(user);
                refreshToken = jwtService.generateRefreshToken(user);
                revokeAllUserTokens(user);
                saveUserToken(userDetails, jwtToken);
            } else {
                log.error("Incorrect Password for user {}", loginRequest.getEmail());
            }

        } catch (Exception ex) {
            log.error("Exception occurred during authentication", ex);
        }



        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private boolean userPasswordIsAuthentication(LoginRequest loginRequest, UserDetails userDetails) {
        return !loginRequest.getPassword().isEmpty() && passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword());
    }

    private void revokeAllUserTokens(UserInfo userInfo) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(userInfo.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public void refreshToken(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        final String authHeader = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserEmail(refreshToken);
        if (userEmail != null) {
            var userDetails = this.userRepository.findByEmail(userEmail)
                    .orElseThrow();
            var user = userDetailMapper.map(userDetails);
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(userDetails, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(httpServletResponse.getOutputStream(), authResponse);
            }
        }
    }

    private void saveUserToken(UserDetails userDetails, String jwtToken) {
        var token = Token.builder()
                .userDetails(userDetails)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }
}
