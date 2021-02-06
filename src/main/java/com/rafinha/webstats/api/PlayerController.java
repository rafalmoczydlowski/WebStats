package com.rafinha.webstats.api;

import com.rafinha.webstats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        modelMap.put("players", playerService.showAllPlayers());
        return "players-list";
    }

    @GetMapping("/add-player")
    public String showAddPlayerPage() {
        return "player";
    }

    @PostMapping("/add-player")
    public String addPlayer(ModelMap modelMap, @RequestParam String name, @RequestParam String surname, @RequestParam String club) {
        playerService.addPlayer(name, surname, club);
        return "redirect:/players-list";
    }

}
