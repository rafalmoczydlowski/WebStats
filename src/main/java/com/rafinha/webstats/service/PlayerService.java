package com.rafinha.webstats.service;

import com.rafinha.webstats.model.Player;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {

    private static List<Player> players = new ArrayList<>();
    private static final String FC_BARCELONA = "fc-barcelona";

    static {
        players.add(new Player(1,"Marc Andre", "ter Stegen", FC_BARCELONA));
        players.add(new Player(2,"Jordi", "Alba", FC_BARCELONA));
        players.add(new Player(3,"Frankie", "de Jong", FC_BARCELONA));
        players.add(new Player(4,"Lionel", "Messi", FC_BARCELONA));
    }

    private static int count = players.size();

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

    public static void addPlayer(String name, String surname, String club) {
        players.add(new Player(++count, name, surname, club));
    }

    public void deletePlayerById(int id) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if(player.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Player retrievePlayer(int id) {
        for (Player player : players) {
            if(player.getId() == id)
                return player;
        }
        return null;
    }

    public static void updatePlayer(int id, String name, String surname, String club) {
        players.add(new Player(id, name, surname, club));
    }


    public int findFirstFreeIdInClub() {
        List<Integer> idList = new ArrayList<>();
        int min = 1;
        for (Player player : players)
            idList.add(player.getId());

        for (int id : idList) {
            if (id == min)
                min++;
        }
        return min;
    }
}
