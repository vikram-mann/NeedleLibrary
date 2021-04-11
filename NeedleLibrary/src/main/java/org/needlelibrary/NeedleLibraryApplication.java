package org.needlelibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NeedleLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeedleLibraryApplication.class, args);
	}

}
