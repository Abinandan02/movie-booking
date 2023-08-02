package com.movie.ticketbookingservice.controller;

import com.movie.ticketbookingservice.dto.LoginRequest;
import com.movie.ticketbookingservice.dto.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @PostMapping
    public ResponseEntity<LoginResponse> performLogin(@Valid @RequestBody LoginRequest loginRequestDTO){
        return ResponseEntity.ok(new LoginResponse("Success !"));
    }
}
