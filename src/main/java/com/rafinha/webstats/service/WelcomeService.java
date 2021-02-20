package com.rafinha.webstats.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

    @Value("${welcome.message}")
    private String welcomeMessage;

    public String retreiveWelcomeMessage() {
        return welcomeMessage;
    }
}
