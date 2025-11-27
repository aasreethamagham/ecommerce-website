package com.example.ecommerce.service;

import com.example.ecommerce.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    // called by Spring Security to load user by username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser app = userService.findByUsername(username);
        if (app == null) throw new UsernameNotFoundException("User not found: " + username);

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + app.getRole());
        return new User(app.getUsername(), app.getPassword(), Collections.singleton(authority));
    }
}


