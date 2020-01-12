package distrsystems.htwproject.veganrecipesinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VeganRecipesInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeganRecipesInfoServiceApplication.class, args);
	}

}
