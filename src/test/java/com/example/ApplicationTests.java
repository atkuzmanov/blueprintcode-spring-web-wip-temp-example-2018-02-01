package com.example;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ApplicationTests {
	@Test
	public void exampleContextLoadsTest() {
	}
}
