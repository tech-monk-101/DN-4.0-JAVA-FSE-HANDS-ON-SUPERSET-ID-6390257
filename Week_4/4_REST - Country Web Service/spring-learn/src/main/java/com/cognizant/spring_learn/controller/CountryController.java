package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;

@RestController
public class CountryController {
	private static final Logger log = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	@Qualifier("in")
	Country in;
	@RequestMapping("/country")
	public Country getCountryIndia() {
		log.info("METHOD getCountryIndia() STARTED");
		log.info("METHOD getCountryIndia() COMPLETED");
		return in;
	}
}