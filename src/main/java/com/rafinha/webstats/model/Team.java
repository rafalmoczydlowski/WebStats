package com.rafinha.webstats.model;

import java.util.List;
import java.util.Objects;

public class Team {
    private int id;
    private String name;
    private List<Player> players;

    public Team() {
        super();
    }

    public Team(int id, String name, List<Player> players) {
        super();
        this.id = id;
        this.name = name;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return String.format("Team [id=%d, name=%s, players=%s]", id, name, players);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
