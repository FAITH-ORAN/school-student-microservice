package com.example.auth_service.service;

import com.example.auth_service.entity.User;

import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
}
