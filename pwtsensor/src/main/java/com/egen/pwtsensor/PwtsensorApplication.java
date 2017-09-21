package com.egen.pwtsensor;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;

@SpringBootApplication(exclude = EmbeddedMongoAutoConfiguration.class)
public class PwtsensorApplication {
	final static Logger logger = Logger.getLogger(PwtsensorApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(PwtsensorApplication.class, args);

	}
}
