package com.rafinha.webstats.api;

import com.rafinha.webstats.model.Player;
import com.rafinha.webstats.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams/{clubName}/players")
    public List<Player> retrievePlayersForTeam(@PathVariable String clubName) {
        return teamService.retrievePlayersByClubName(clubName);
    }

    @GetMapping("/teams/{clubName}/players/{playerId}")
    public Player retrieveDetailsForPlayer(@PathVariable String clubName, @PathVariable int playerId) {
        return teamService.retrievePlayerByClubNameAndPlayerId(clubName, playerId);

    }
}
