package com.rafinha.webstats.jpa;

import com.rafinha.webstats.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
