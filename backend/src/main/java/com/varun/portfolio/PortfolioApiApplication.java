package com.varun.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class PortfolioApiApplication {

	public static void main(String[] args) {

		// Run the JVM in UTC so the database connection and all timestamps
		// behave the same on this laptop and on the production server.
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		SpringApplication.run(PortfolioApiApplication.class, args);
	}
}
