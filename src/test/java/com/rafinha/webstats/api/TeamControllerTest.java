package com.rafinha.webstats.api;

import com.rafinha.webstats.model.Player;
import com.rafinha.webstats.service.TeamService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamService teamService;

    @Test
    public void retrievePlayerFromClubByIdTest() throws Exception {
        Player mockPlayer = new Player(1,"Marc Andre", "ter Stegen", "fc-barcelona");
        Mockito.when(teamService.retrievePlayerByClubNameAndPlayerId(Mockito.anyString(), Mockito.anyInt())).thenReturn(mockPlayer);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/teams/fc-barcelona/players/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"name\":\"Marc Andre\",\"surname\":\"ter Stegen\",\"club\":\"fc-barcelona\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void retrievePlayersForTeamTest() throws Exception {
        List<Player> mockPlayerList = Arrays.asList(
                new Player(1,"Marc Andre", "ter Stegen", "fc-barcelona"),
                new Player(2,"Jordi", "Alba", "fc-barcelona")
        );
        Mockito.when(teamService.retrievePlayersByClubName(Mockito.anyString())).thenReturn(mockPlayerList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/teams/fc-barcelona/players").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
        String expected = "["
                + "{\"id\":1,\"name\":\"Marc Andre\",\"surname\":\"ter Stegen\",\"club\":\"fc-barcelona\"},"
                + "{\"id\":2,\"name\":\"Jordi\",\"surname\":\"Alba\",\"club\":\"fc-barcelona\"}"
                + "]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void addPlayerForTeamTest() throws Exception {
        Player mockPlayer = new Player(1, "Rafał", "Moczydłowski", "fc-barcelona");
        String playerJSON = "{\"name\":\"Rafał\",\"surname\":\"Moczydłowski\",\"club\":\"fc-barcelona\"}";

        Mockito.when(teamService.addPlayerToTeam(Mockito.anyString(), Mockito.any(Player.class))).thenReturn(mockPlayer);
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.post("/teams/fc-barcelona/players")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(playerJSON)
                        .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        Assert.assertEquals("http://localhost/teams/fc-barcelona/players/1", response.getHeader(HttpHeaders.LOCATION));
    }
}
