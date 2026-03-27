package com.example.HiveBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HiveBoxApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(HiveBoxApplication.class, args);
		System.out.println("My current Application Version is : v0.0.1");
		context.close();
	}

}
