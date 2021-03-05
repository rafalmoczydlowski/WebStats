package com.rafinha.webstats.api;

import com.rafinha.webstats.jpa.PlayerRepository;
import com.rafinha.webstats.model.Player;
import com.rafinha.webstats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PlayerController {

    private static final String REDIRECT_1 = "redirect:/players-list";
    private static final String PLAYER = "player";

    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

    @GetMapping("/players-list")
    public String showPlayersList(ModelMap modelMap) {
        String name = getLoggedInUserName();
        modelMap.put("name", name);
        modelMap.put("players", playerRepository.findAll());
        return "players-list";
    }

    @GetMapping("/add-player")
    public String showAddPlayerPage(ModelMap modelMap) {
        modelMap.addAttribute(PLAYER, new Player(0, "Default Name", "Default Surname", "Default Club"));
        return PLAYER;
    }

    @PostMapping("/add-player")
    public String addPlayer(@Valid Player player, BindingResult result) {
        if(result.hasErrors())
            return PLAYER;

        playerRepository.save(player);
        PlayerService.addPlayer(player.getName(), player.getSurname(), player.getClub());
        return REDIRECT_1;
    }

    @GetMapping(value = "/delete-player")
    public String deletePlayer(@RequestParam int id) {
        playerRepository.deleteById(id);
        playerService.deletePlayerById(id);
        return REDIRECT_1;
    }

    @GetMapping("/update-player")
    public String showUpdatePlayerPage(@RequestParam int id, ModelMap modelMap) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent())
            modelMap.put(PLAYER, player.get());
        return PLAYER;
    }

    @PostMapping("/update-player")
    public String updatePlayer(@RequestParam int id, @Valid Player player, BindingResult result) {
        if(result.hasErrors())
            return PLAYER;
        playerRepository.deleteById(id);
        playerService.deletePlayerById(id);
        playerRepository.save(player);
        PlayerService.updatePlayer(id ,player.getName(), player.getSurname(), player.getClub());
        return REDIRECT_1;
    }

    private String getLoggedInUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();
        return principal.toString();
    }
}
