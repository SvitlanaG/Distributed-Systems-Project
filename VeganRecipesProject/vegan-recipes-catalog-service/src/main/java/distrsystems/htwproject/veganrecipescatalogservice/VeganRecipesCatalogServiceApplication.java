package distrsystems.htwproject.veganrecipescatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VeganRecipesCatalogServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(VeganRecipesCatalogServiceApplication.class, args);
	}

}
