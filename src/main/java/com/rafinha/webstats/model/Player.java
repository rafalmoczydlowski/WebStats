package com.rafinha.webstats.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Player {

    private final UUID id;
    @NotBlank(message = "Name may not be blank")
    private final String name;
    @NotBlank(message = "Name may not be blank")
    private final String surname;

    public Player(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name,
                  @JsonProperty("surname") String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
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
}
