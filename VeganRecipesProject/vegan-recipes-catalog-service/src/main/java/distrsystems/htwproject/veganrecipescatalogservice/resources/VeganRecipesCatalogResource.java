package distrsystems.htwproject.veganrecipescatalogservice.resources;

import distrsystems.htwproject.veganrecipescatalogservice.models.CatalogItem;
import distrsystems.htwproject.veganrecipescatalogservice.models.Recipe;
import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

// get all rated recipe IDs
// For each Id, call recipe info service and get details
// put them all together

@RestController
@RequestMapping("/catalog")
public class VeganRecipesCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        WebClient.Builder builder = WebClient.builder();

            UserRating userRating = builder.build()
                    .get()
                    .uri("http://localhost:8083/ratingsdata/users/" + userId)
                    .retrieve()
                    .bodyToMono(UserRating.class)
                    .block();


        // call recipe info api from the catalog service
        return userRating.getUserRating().stream().map(rating -> {

            Recipe recipe = builder.build()
                    .get()
                    .uri("http://localhost:8082/vegan-recipes/" + rating.getRecipeId())
                    .retrieve()
                    .bodyToMono(Recipe.class)
                    .block();
            return new CatalogItem(recipe.getName(), recipe.getDesc(), rating.getRating());
        })
                .collect(Collectors.toList());
    }
}








