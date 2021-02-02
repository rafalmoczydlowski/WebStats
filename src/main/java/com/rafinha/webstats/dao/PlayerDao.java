package com.rafinha.webstats.dao;

import com.rafinha.webstats.model.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerDao {

    int insertPlayer(UUID id, Player player);

    default int insertPlayer(Player player) {
        UUID id = UUID.randomUUID();
        return insertPlayer(id, player);
    }

    List<Player> selectAllPlayers();

    Optional<Player> selectPlayerById(UUID id);

    int deletePlayerById(UUID id);

    int updatePlayerById(UUID id, Player player);
}
