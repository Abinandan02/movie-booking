package com.movie.ticketbookingservice.service;

import com.movie.ticketbookingservice.dto.User;
import com.movie.ticketbookingservice.exception.NoSuchElementFoundException;
import com.movie.ticketbookingservice.mapper.UserDetailMapper;
import com.movie.ticketbookingservice.model.UserDetails;
import com.movie.ticketbookingservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDetailMapper userDetailMapper;

    @Override
    public User getUserDetails(Long id) throws NoSuchElementFoundException {
        Optional<UserDetails> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            log.info("user not found with id {}", id);
            throw new NoSuchElementFoundException();
        }
        return userDetailMapper.map(userOptional.get());
    }
}
