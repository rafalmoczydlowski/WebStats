package com.rafinha.webstats.api;

import com.rafinha.webstats.model.Player;
import com.rafinha.webstats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String showAddPlayerPage(ModelMap modelMap) {
        modelMap.addAttribute("player", new Player(0, "Default Name", "Default Surname", "Default Club"));
        return "player";
    }

    @PostMapping("/add-player")
    public String addPlayer(@Valid Player player, BindingResult result) {
        if(result.hasErrors())
            return "player";

        PlayerService.addPlayer(player.getName(), player.getSurname(), player.getClub());
        return "redirect:/players-list";
    }

    @GetMapping(value = "/delete-player")
    public String deletePlayer(@RequestParam int id) {
        playerService.deletePlayerById(id);
        return "redirect:/players-list";
    }

    @GetMapping("/update-player")
    public String showUpdatePlayerPage(@RequestParam int id, ModelMap modelMap) {
        Player player = playerService.retrievePlayer(id);
        modelMap.put("player", player);
        return "player";
    }

    @PostMapping("/update-player")
    public String updatePlayer(@RequestParam int id, @Valid Player player, BindingResult result) {
        if(result.hasErrors())
            return "player";
        playerService.deletePlayerById(id);
        PlayerService.updatePlayer(id ,player.getName(), player.getSurname(), player.getClub());
        return "redirect:/players-list";
    }
}
