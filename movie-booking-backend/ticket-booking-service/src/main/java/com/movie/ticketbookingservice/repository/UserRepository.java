package com.movie.ticketbookingservice.repository;

import com.movie.ticketbookingservice.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

    Optional<UserDetails> findByEmail(String email);

}
