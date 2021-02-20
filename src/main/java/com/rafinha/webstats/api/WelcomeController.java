package com.rafinha.webstats.api;

import com.rafinha.webstats.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Autowired
    WelcomeService service;

    @GetMapping("/")
    public String showWelcomePage(ModelMap modelMap) {
        modelMap.put("name", getLoggedInUserName());
        return "welcome";
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();
        return principal.toString();
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return service.retreiveWelcomeMessage();
    }
}
