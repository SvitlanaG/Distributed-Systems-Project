package distrsystems.htwproject.veganrecipescatalogservice.resources;


import distrsystems.htwproject.veganrecipescatalogservice.service.RecipeClient;
import distrsystems.htwproject.veganrecipescatalogservice.service.RecipeClientImpl;
import distrsystems.htwproject.veganrecipescatalogservice.service.UserRatingClient;
import distrsystems.htwproject.veganrecipescatalogservice.service.UserRatingClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

   // @LoadBalanced
    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();

    }

    @Bean
    public UserRatingClient getUserRatingClient(){
        return new UserRatingClientImpl();
    }

    @Bean
    public RecipeClient recipeClient() {
        return new RecipeClientImpl();
    }

}
