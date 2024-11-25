package D288_com.example.D288_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class D288SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(D288SpringApplication.class, args);
	}

}
