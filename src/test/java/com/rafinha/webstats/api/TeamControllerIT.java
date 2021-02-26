package com.rafinha.webstats.api;

import com.rafinha.webstats.WebstatsApplication;
import com.rafinha.webstats.model.Player;
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

    private ResponseEntity<String> getResponseEntityByPlayersId(int playerId) {
        String url = "http://localhost:"+portNumber+"/teams/fc-barcelona/players/"+playerId;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity entity = new HttpEntity(null, headers);
        TestRestTemplate restTemplate = new TestRestTemplate();
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
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
        String url = "http://localhost:"+portNumber+"/teams/fc-barcelona/players/";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        ResponseEntity<List<Player>> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>("DOESN'T MATTER", headers), new ParameterizedTypeReference<List<Player>>(){});

        Player examplePlayer = new Player(1,"Marc Andre", "ter Stegen", "fc-barcelona");

        assertTrue(response.getBody().contains(examplePlayer));
    }

    @Test
    public void createTeamPlayer() {
        String url = "http://localhost:"+portNumber+"/teams/fc-barcelona/players/";
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        Player player = new Player(5, "Rafał", "Moczydłowski", "fc-barcelona");

        HttpEntity entity = new HttpEntity<>(player, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        assertTrue(actual.contains("/teams/fc-barcelona/players/"));
    }
}
