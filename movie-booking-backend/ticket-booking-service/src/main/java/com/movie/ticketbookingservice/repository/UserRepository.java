package com.movie.ticketbookingservice.repository;

import com.movie.ticketbookingservice.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
}
