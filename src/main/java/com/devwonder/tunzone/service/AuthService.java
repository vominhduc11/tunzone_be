package com.devwonder.tunzone.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devwonder.tunzone.entity.Account;

@Service
public class AuthService {

    public ResponseEntity<?> register(Account user) {
        // TODO: Implement registration logic
        return ResponseEntity.ok("User registered successfully");
    }

    public ResponseEntity<?> login(Account user) {
        // TODO: Implement login logic here
        return ResponseEntity.ok("Login successful");
    }
}