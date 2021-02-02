package com.rafinha.webstats.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String getLoginMessage() {
        return "Witaj w programie WebStats! Zmodyfikowano";
    }
}
