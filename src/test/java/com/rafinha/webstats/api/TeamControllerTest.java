package com.rafinha.webstats.api;

import com.rafinha.webstats.model.Player;
import com.rafinha.webstats.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
}
