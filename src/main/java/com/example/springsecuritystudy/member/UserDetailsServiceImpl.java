package com.example.springsecuritystudy.member;

import com.example.springsecuritystudy.enums.Role;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = User.builder()
            .username(username)
            .password("password")
            .roles(Role.USER.getRole())
            .build();

        return userDetails;
    }
}
