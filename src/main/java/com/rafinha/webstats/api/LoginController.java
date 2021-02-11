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

    @GetMapping("/")
    public String showLoginPage(ModelMap modelMap) {
        modelMap.put("name", "Rafał");
        return "welcome";
    }
}
