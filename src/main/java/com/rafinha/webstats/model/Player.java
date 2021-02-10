package com.rafinha.webstats.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Player {

    private int id;
    @NotBlank(message = "Name may not be blank")
    @Pattern(regexp = "^[/^[\\s\\p{L}]+$/u]+$", message = "Only letters")
    @Size(min = 2, message = "The name must be at least 2 characters long")
    private String name;
    @NotBlank(message = "Name may not be blank")
    @Pattern(regexp = "^[/^[\\s\\p{L}]+$/u]+$", message = "Only letters")
    @Size(min = 2, message = "The name must be at least 2 characters long")
    private String surname;
    @NotBlank(message = "Name may not be blank")
    @Size(min = 2, message = "The name must be at least 2 characters long")
    private String club;

    public Player() {
        super();
    }

    public Player(int id, String name, String surname, String club) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.club = club;
    }

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
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
        return id == other.id;
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
