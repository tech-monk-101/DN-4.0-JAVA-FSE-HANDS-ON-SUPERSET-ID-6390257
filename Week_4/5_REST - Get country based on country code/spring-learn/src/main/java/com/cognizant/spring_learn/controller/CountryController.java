package com.cognizant.spring_learn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.spring_learn.Country;

@RestController
public class CountryController {
	private static final Logger log = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	@Qualifier("countryList")
	List<Country> countryList;

	@RequestMapping("/country/{code}")

	public Country getCountry(@PathVariable String code) {
		log.info("FETCHING COUNTRY CODE : " + code);
		Country res =  countryList.stream().filter(c -> c.getCode()
				.equalsIgnoreCase(code)).findFirst().orElse(null);
		log.info("FETCHED COUNTRY CODE : " + code);
		return res;
	}
}