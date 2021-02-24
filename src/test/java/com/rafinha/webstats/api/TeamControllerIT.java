package com.rafinha.webstats.api;

import com.rafinha.webstats.WebstatsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebstatsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamControllerIT {

    @LocalServerPort
    private int portNumber;

    @Test
    public void portTest() {
        System.out.println("PORT: " + portNumber);
    }
}
