package com.movie.ticketbookingservice.adapter;

import com.movie.ticketbookingservice.dto.UserInfo;
import com.movie.ticketbookingservice.exception.NoSuchElementFoundException;
import com.movie.ticketbookingservice.mapper.UserDetailMapper;
import com.movie.ticketbookingservice.model.UserDetails;
import com.movie.ticketbookingservice.repository.UserRepository;
import com.movie.ticketbookingservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public UserInfo getUserDetails(Long id) throws NoSuchElementFoundException {
        Optional<UserDetails> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            log.info("user not found with id {}", id);
            throw new NoSuchElementFoundException();
        }
        return userDetailMapper.map(userOptional.get());
    }
}
