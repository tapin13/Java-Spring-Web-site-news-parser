package com.example.newsparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsParserApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsParserApplication.class, args);
	}

}
