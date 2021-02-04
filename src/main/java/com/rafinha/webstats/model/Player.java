package com.rafinha.webstats.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Player {

    private final UUID id;
    @NotBlank(message = "Name may not be blank")
    private String name;
    @NotBlank(message = "Name may not be blank")
    private String surname;
    private String club;

    public Player(UUID id, String name, String surname, String club) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.club = club;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getClub() {
        return club;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Player other = (Player) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", club='" + club + '\'' +
                '}';
    }
}
