package distrsystems.htwproject.veganrecipescatalogservice.services;

import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

public class UserRatingClientImpl implements UserRatingClient {


    @Autowired
    private WebClient.Builder webClientBuilder;

    public UserRatingClientImpl() {
    }

    @Override
    public UserRating getUserRatig(String userId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/userrating/list")
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();
    }
}
