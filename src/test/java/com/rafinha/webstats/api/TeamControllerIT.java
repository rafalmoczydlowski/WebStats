package com.rafinha.webstats.api;

import com.rafinha.webstats.WebstatsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

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
}
