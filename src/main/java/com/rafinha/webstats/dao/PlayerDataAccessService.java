package com.rafinha.webstats.dao;

import com.rafinha.webstats.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("daoList")
public class PlayerDataAccessService implements PlayerDao {

    private static List<Player> playerList = new ArrayList<>();

    @Override
    public int insertPlayer(UUID id, Player player) {
        playerList.add(new Player(id, player.getName(), player.getSurname()));
        return 1;
    }

    @Override
    public List<Player> selectAllPlayers() {
        return playerList;
    }

    @Override
    public Optional<Player> selectPlayerById(UUID id) {
        return playerList.stream().filter(player -> player.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePlayerById(UUID id) {
        Optional<Player> maybeDelete = selectPlayerById(id);
        if (maybeDelete.isEmpty()) {
            return 0;
        }
        playerList.remove(maybeDelete.get());
        return 1;
    }

    @Override
    public int updatePlayerById(UUID id, Player playerToUpdate) {
        return selectPlayerById(id).map(player1 -> {
            int indexOfPlayerToUpdate = playerList.indexOf(player1);
            if (indexOfPlayerToUpdate >= 0) {
                playerList.set(indexOfPlayerToUpdate, new Player(id, playerToUpdate.getName(), playerToUpdate.getSurname()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }
}
