package com.example.HiveBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for HiveBox Spring Boot application.
 */
@SpringBootApplication
public final class HiveBoxApplication {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private HiveBoxApplication() {
	}

	/**
	 * Main method to start the application.
	 *
	 * @param args command-line arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(HiveBoxApplication.class, args);
	}
}