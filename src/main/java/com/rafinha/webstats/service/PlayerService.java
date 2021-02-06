package com.rafinha.webstats.service;

import com.rafinha.webstats.model.Player;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {

    private static List<Player> players = new ArrayList<>();
    private static final String FC_BARCELONA = "FC Barcelona";

    static {
        players.add(new Player(UUID.randomUUID(),"Marc Andre", "ter Stegen", FC_BARCELONA));
        players.add(new Player(UUID.randomUUID(),"Jordi", "Alba", FC_BARCELONA));
        players.add(new Player(UUID.randomUUID(),"Frankie", "de Jong", FC_BARCELONA));
        players.add(new Player(UUID.randomUUID(),"Lionel", "Messi", FC_BARCELONA));
    }

    public List<Player> showAllPlayers() {
        List<Player> allPlayers = new ArrayList<>();
        for (Player player : players)
            allPlayers.add(player);
        return allPlayers;
    }

    public List<Player> retrievePlayersByClub(String club) {
        List<Player> filteredPlayersByClub = new ArrayList<>();
        for (Player player : players) {
            if (player.getClub().equals(club)) {
                filteredPlayersByClub.add(player);
            }
        }
        return filteredPlayersByClub;
    }

    public void addPlayer(String name, String surname, String club) {
        players.add(new Player(UUID.randomUUID(), name, surname, club));
    }

    public void deletePlayerById(UUID uuid) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if(player.getId() == uuid) {
                iterator.remove();
            }
        }
    }
}
