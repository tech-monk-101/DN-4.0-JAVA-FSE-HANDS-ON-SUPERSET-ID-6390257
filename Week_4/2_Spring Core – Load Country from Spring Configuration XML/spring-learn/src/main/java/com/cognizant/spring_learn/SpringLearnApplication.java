package com.cognizant.spring_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:country.xml")
public class SpringLearnApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringLearnApplication.class);

    @Autowired
    private List<Country> countryList;

    public void displayCountries() {
        for (Country country : countryList) {
            log.debug("Country: {}", country.getName());
        }
    }
    
    public static void main(String[] args) {
        var context = SpringApplication.run(SpringLearnApplication.class, args);
        SpringLearnApplication app = context.getBean(SpringLearnApplication.class);
        app.displayCountries();
    }
}
