package com.rafinha.webstats.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userId, String password) {
        return userId.equalsIgnoreCase("Rafał")
                && password.equalsIgnoreCase("password");
    }
}
