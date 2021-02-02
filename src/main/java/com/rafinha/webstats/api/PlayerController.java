package com.rafinha.webstats.api;

import com.rafinha.webstats.model.Player;
import com.rafinha.webstats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/player")
@RestController
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public void addPlayer(@Valid @NonNull @RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping(path = "{id}")
    public Player getPlayerById(@PathVariable("id") UUID id) {
        return playerService.getPlayerById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePlayerById(@PathVariable("id") UUID id) {
        playerService.deletePlayer(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,
                             @Valid @NonNull @RequestBody Player playerToUpdate) {
        playerService.updatePlayer(id, playerToUpdate);
    }
}
