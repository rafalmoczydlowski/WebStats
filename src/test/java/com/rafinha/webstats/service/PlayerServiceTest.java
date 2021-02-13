package com.rafinha.webstats.service;

import com.rafinha.webstats.model.Player;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PlayerServiceTest {

    PlayerService playerService = new PlayerService();

    Object[] expectedPlayers = new Object[4];

    @Before
    public void initPlayers() {
        expectedPlayers[0] = new Player(1,"Marc Andre", "ter Stegen", "FC Barcelona");
        expectedPlayers[1] = new Player(2,"Jordi", "Alba", "FC Barcelona");
        expectedPlayers[2] = new Player(3,"Frankie", "de Jong", "FC Barcelona");
        expectedPlayers[3] = new Player(4,"Lionel", "Messi", "FC Barcelona");
    }

    @Test
    public void showAllPlayersTest() {
        Object[] testOutput = playerService.showAllPlayers().toArray();
        assertArrayEquals(expectedPlayers, testOutput);
    }

    @Test
    public void retrievePlayersByClubTest() {
        Object[] fcBarcelonaPlayers = playerService.retrievePlayersByClub("FC Barcelona").toArray();
        assertArrayEquals(expectedPlayers, fcBarcelonaPlayers);
    }

    @Test
    public void addPlayerTest() {
        PlayerService.addPlayer("Rafał", "Moczydłowski", "Wisła Jabłonna");
        Object[] testOutput = playerService.showAllPlayers().toArray();
        Object[] newExpectedPlayers = new Object[expectedPlayers.length+1];
        System.arraycopy(expectedPlayers,0, newExpectedPlayers,0,4);
        newExpectedPlayers[4] = new Player(5, "Rafał", "Moczydłowski", "Wisła Jabłonna");
        assertArrayEquals(newExpectedPlayers, testOutput);
    }

    @Test
    public void retrieveFirstPlayerName() {
        String nameOfFirstPlayer = playerService.retrievePlayer(1).getName();
        String expectedString = "Marc Andre";
        assertEquals(expectedString, nameOfFirstPlayer);
    }

    @Test
    public void retrieveSecondPlayerSurname() {
        String surnameOfSecondPlayer = playerService.retrievePlayer(2).getSurname();
        String expectedString = "Alba";
        assertEquals(expectedString, surnameOfSecondPlayer);
    }
}
