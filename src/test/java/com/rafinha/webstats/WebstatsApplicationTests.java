package com.rafinha.webstats;

import com.rafinha.webstats.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WebstatsApplicationTests {

	@Autowired
	LoginService loginService;

	@Test
	public void showErrorMessage() {
		boolean validate = loginService.validateUser("Rafał", "qweqweasd");
		assertEquals(false, validate);
	}

	@Test
	public void provideCorrectData() {
		boolean validate = loginService.validateUser("Rafał", "password");
		assertEquals(true, validate);
	}
}
