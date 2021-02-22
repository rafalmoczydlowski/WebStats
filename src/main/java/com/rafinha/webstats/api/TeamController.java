package com.rafinha.webstats.api;

import com.rafinha.webstats.model.Player;
import com.rafinha.webstats.model.Team;
import com.rafinha.webstats.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<Team> retrieveTeams() {
        return teamService.retrieveAllTeams();
    }

    @GetMapping("/teams/{clubName}/players")
    public List<Player> retrievePlayersForTeam(@PathVariable String clubName) {
        return teamService.retrievePlayersByClubName(clubName);
    }

    @PostMapping("/teams/{clubName}/players")
    public ResponseEntity<Void> addPlayerForTeam(@PathVariable String clubName, @RequestBody Player player) {
        // adding a new player
        Player newPlayer = teamService.addPlayerToTeam(clubName, player);

        if (player==null)
            return ResponseEntity.noContent().build();
        // replacing new player's ID into URI
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newPlayer.getId()).toUri();
        // returning status
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/teams/{clubName}/players/{playerId}")
    public Player retrievePlayerFromClubById(@PathVariable String clubName, @PathVariable int playerId) {
        return teamService.retrievePlayerByClubNameAndPlayerId(clubName, playerId);
    }
}
