package com.projekt.genesis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class GenesisApplication {



	public static void main(String[] args) {
		SpringApplication.run(GenesisApplication.class, args);
	}

	@Bean
	public CommandLineRunner createPersonIdFile() {
		return args -> {
			Path filePath = Paths.get("src/main/resources/dataPersonId.txt");
			if (!Files.exists(filePath)) {
				List<String> personIds = List.of(
						"jXa4g3H7oPq2",
						"yB9fR6tK0wLm",
						"cN1vZ8pE5sYx",
						"tQdG2kP3mJfB",
						"iM5sO6zXcW7v",
						"rU8nA9eT2bYh",
						"wV6eH1fK7qZj",
						"sL4gN9dC3bXz",
						"kR0aZ7vW2nDl",
						"eI1oY6tQ9dKj",
						"gT4cR7wS0lVx",
						"xF9hD2yJ3sWv",
						"hM5bZ8nK4aVf",
						"qE3lY6uT0vKd",
						"bG2zC7jR9xVp",
						"vB1fX4rH7iNt",
						"aO8kP3mZ6dIw",
						"dW9pL2eU1yNc",
						"nS7tJ0qR5wGh",
						"mY6sT1jA3cLz"
				);
				Files.write(filePath, personIds);
			}
		};
	}
}