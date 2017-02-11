package de.ch4inl3ss;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.ch4inl3ss.entity.Programmer;
import de.ch4inl3ss.repository.ProgrammerRepository;

@SpringBootApplication
public class LegacyExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegacyExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner addCustomers(ProgrammerRepository repository) {
		return (args) -> {
			// save a couple of customers

			repository.save(new Programmer("James", "Gosling", 60));
			repository.save(new Programmer("Donald", "Knuth", 77));
			repository.save(new Programmer("Ken", "Thompson", 72));

		};
	}
}
