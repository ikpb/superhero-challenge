package com.ikpb.flashcards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FlashCardAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashCardAppApplication.class, args);
	}

}
