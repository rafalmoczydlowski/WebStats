package com.rafinha.webstats.api;

import com.rafinha.webstats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/players-list")
    public String showPlayersList(ModelMap modelMap) {
        String name = (String) modelMap.get("name");
        modelMap.put("name", name);
        modelMap.put("fcbarcelona", playerService.retrievePlayersByClub("FC Barcelona"));
        return "players-list";
    }

}
