package distrsystems.htwproject.veganrecipescatalogservice.resources;


import distrsystems.htwproject.veganrecipescatalogservice.services.RecipeClient;
import distrsystems.htwproject.veganrecipescatalogservice.services.RecipeClientImpl;
import distrsystems.htwproject.veganrecipescatalogservice.services.UserRatingClient;
import distrsystems.htwproject.veganrecipescatalogservice.services.UserRatingClientImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

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
