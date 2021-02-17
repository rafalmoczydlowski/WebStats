package com.rafinha.webstats.service;

import com.rafinha.webstats.model.Player;
import com.rafinha.webstats.model.Team;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;

@Component
public class TeamService {
    private static List<Team> teams = new ArrayList<>();
    private static int count = teams.size();
    private SecureRandom secureRandom = new SecureRandom();

    static {
        //initialize player list
        PlayerService playerService = new PlayerService();

        List<Player> players = new ArrayList<>(playerService.showAllPlayers());

        //initialize a team with the given players
        Team fcBarcelona = new Team(1, "FC Barcelona", players);

        teams.add(fcBarcelona);
    }

    public List<Team> retrieveAllTeams() {
        return teams;
    }

    public Team retrieveTeamByName(String clubNameFilter) {
        for (Team team : teams) {
            if (team.getClubName().equals(clubNameFilter)) {
                return team;
            }
        }
        return null;
    }

    public Team retrieveTeamById(int clubIdFilter) {
        for (Team team : teams) {
            if(team.getId() == clubIdFilter)
                return team;
        }
        return null;
    }

    public String retrieveClubNameByTeamId(int clubIdFilter) {
        for (Team team : teams) {
            if (team.getId() == clubIdFilter)
                return team.getClubName();
        }
        return null;
    }

    public List<Player> retrievePlayersByClubId(int teamId) {
        Team team = retrieveTeamById(teamId);

        if (team == null)
            return Collections.emptyList();

        return team.getPlayers();
    }

    public List<Player> retrievePlayersByClubName(String clubName) {
        Team team = retrieveTeamByName(clubName);

        if (team == null)
            return Collections.emptyList();

        return team.getPlayers();
    }

    public Player retrievePlayer(int teamId, int playerId) {
        Team team = retrieveTeamById(teamId);

        if(team == null)
            return null;

        for (Player player : team.getPlayers()) {
            if (player.getId() == playerId)
                return player;
        }
        return null;
    }

    public static void addTeam(String clubName) {
        teams.add(new Team(++count, clubName, new ArrayList<>()));
    }

    public Player addPlayer(int teamId, Player player) {
        Team team = retrieveTeamById(teamId);

        if (team == null) {
            return null;
        }

        int randomId = new BigInteger(130, secureRandom).intValue();
        player.setId(randomId);

        team.getPlayers().add(player);

        return player;
    }

    public void deleteClubById(int teamId) {
        Iterator<Team> iterator = teams.iterator();
        while (iterator.hasNext()) {
            Team team = iterator.next();
            if(team.getId() == teamId) {
                iterator.remove();
            }
        }
    }
}
