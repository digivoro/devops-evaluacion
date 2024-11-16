package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	void helloMessage() {
		TestRestTemplate restTemplate = new TestRestTemplate();
		String url = "http://localhost:" + port + "/";
		String response = restTemplate.getForObject(url, String.class);
		assertThat(response).isEqualTo("Hola mundo!");
	}
}
