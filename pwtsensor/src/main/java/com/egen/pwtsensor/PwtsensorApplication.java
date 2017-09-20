package com.egen.pwtsensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

@SpringBootApplication(exclude = EmbeddedMongoAutoConfiguration.class)
public class PwtsensorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PwtsensorApplication.class, args);
	}
}
