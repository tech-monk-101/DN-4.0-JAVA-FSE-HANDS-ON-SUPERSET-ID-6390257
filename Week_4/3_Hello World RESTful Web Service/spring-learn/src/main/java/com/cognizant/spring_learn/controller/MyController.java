package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	private static final Logger log = LoggerFactory.getLogger(MyController.class);
	
	@GetMapping("/hello")
	public String displayHello() {
		log.info("METHOD displayHello() STARTED");
		String message = "Hello Cognizant!";
		log.info("METHOD displayHello() ENDED");
		return message;
	}
}