package com.rafinha.webstats.api;

import com.rafinha.webstats.WebstatsApplication;
import com.rafinha.webstats.model.Player;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebstatsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamControllerIT {

    @LocalServerPort
    private int portNumber;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Before
    public void beforeTest() {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    @Test
    public void playerWith1IdResponseTest() {
        String expectedJSON = "{\"id\":1,\"name\":\"Marc Andre\",\"surname\":\"ter Stegen\",\"club\":\"fc-barcelona\"}";
        ResponseEntity<String> exchange = getResponseEntityByPlayersId(1);
        assertTrue(exchange.getBody().contains("\"id\":1"));
        assertEquals(expectedJSON, exchange.getBody());
    }

    @Test
    public void playerWith2IdResponseTest() {
        String expectedJSON = "{\"id\":2,\"name\":\"Jordi\",\"surname\":\"Alba\",\"club\":\"fc-barcelona\"}";
        ResponseEntity<String> exchange = getResponseEntityByPlayersId(2);
        assertTrue(exchange.getBody().contains("\"id\":2"));
        assertEquals(expectedJSON, exchange.getBody());
    }

    @Test
    public void retrieveAllPlayersFromTeam() {
        Player examplePlayer = new Player(1,"Marc Andre", "ter Stegen", "fc-barcelona");
        ResponseEntity<List<Player>> response = restTemplate.exchange(getURLWithPortNumber(), HttpMethod.GET, new HttpEntity<>("DOESN'T MATTER", headers), new ParameterizedTypeReference<>() {});
        assertTrue(response.getBody().contains(examplePlayer));
    }

    @Test
    public void createTeamPlayer() {
        Player player = new Player(5, "Rafał", "Moczydłowski", "fc-barcelona");
        HttpEntity entity = new HttpEntity<>(player, headers);
        ResponseEntity<String> response = restTemplate.exchange(getURLWithPortNumber(), HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(actual.contains("/teams/fc-barcelona/players/"));
    }

    private String getURLWithPortNumber() {
        return "http://localhost:"+portNumber+"/teams/fc-barcelona/players/";
    }

    private ResponseEntity<String> getResponseEntityByPlayersId(int playerId) {
        HttpEntity entity = new HttpEntity(null, headers);
        return restTemplate.exchange(getURLWithPortNumber()+playerId, HttpMethod.GET, entity, String.class);
    }
}
