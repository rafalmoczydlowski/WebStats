package com.rafinha.webstats.api;

import com.rafinha.webstats.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String showWelcomeMessage(@RequestParam String name, @RequestParam String password, ModelMap modelMap) {
        boolean isValidUser = loginService.validateUser(name, password);
        if(!isValidUser) {
            modelMap.put("validationErrorMessage", "Incorrect data. Try again.");
            return "login";
        }
        modelMap.put("name", name);
        modelMap.put("password", password);
        return "welcome";
    }

    @GetMapping("/welcome")
    public String showWelcomePage() {
        return "welcome";
    }
}
