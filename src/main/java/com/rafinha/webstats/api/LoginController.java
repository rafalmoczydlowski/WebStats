package com.rafinha.webstats.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String getLoginMessage(@RequestParam String name, ModelMap modelMap) {
        modelMap.put("name", name);
        return "login";
    }
}
