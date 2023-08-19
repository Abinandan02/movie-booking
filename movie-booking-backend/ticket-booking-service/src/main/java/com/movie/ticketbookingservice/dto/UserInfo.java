package com.movie.ticketbookingservice.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Data
public class UserInfo implements UserDetails {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    private String phoneNumber;

    private String email;

    private String password;

    private String username;

    private Collection<? extends GrantedAuthority> authorities;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;
}
