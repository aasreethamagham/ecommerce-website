package com.example.ecommerce.service;

import com.example.ecommerce.model.AppUser;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {
    // simple in-memory user store (username -> AppUser)
    private final Map<String, AppUser> users = new ConcurrentHashMap<>();

    public AppUser findByUsername(String username) {
        return users.get(username);
    }

    public void createUser(AppUser user) {
        users.put(user.getUsername(), user);
    }

    public Collection<AppUser> getAllUsers() {
        return users.values();
    }
}

