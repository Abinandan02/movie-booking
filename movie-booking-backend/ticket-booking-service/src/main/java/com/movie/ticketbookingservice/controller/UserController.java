package com.movie.ticketbookingservice.controller;

import com.movie.ticketbookingservice.exception.NoSuchElementFoundException;
import com.movie.ticketbookingservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @GetMapping("/user/{id}")
    ResponseEntity<?> getUserDetails(@PathVariable Long id) throws NoSuchElementFoundException {
        return ResponseEntity.ok().body(userService.getUserDetails(id));
    }


}
