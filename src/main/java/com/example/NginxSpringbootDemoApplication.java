package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class NginxSpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NginxSpringbootDemoApplication.class, args);
	}


	@RestController
	static class HelloRestController {

		@RequestMapping("/hello")
		String hello() {
			return "Hello";
		}

	}

}
