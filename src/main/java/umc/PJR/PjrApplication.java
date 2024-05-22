package umc.PJR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PjrApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjrApplication.class, args);
	}

}
