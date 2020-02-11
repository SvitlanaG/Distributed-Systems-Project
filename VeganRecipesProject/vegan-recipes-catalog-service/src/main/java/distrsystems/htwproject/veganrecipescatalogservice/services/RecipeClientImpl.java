package distrsystems.htwproject.veganrecipescatalogservice.services;

import distrsystems.htwproject.veganrecipescatalogservice.models.CatalogItem;
import distrsystems.htwproject.veganrecipescatalogservice.models.Recipe;
import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

public class RecipeClientImpl implements RecipeClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Override
    public List<CatalogItem> getRecipes(UserRating userRating) {
        return userRating.getUserRating().stream().map(rating -> {

            Recipe recipe = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/vegan-recipes/" + rating.getRecipeId())
                    .retrieve()
                    .bodyToMono(Recipe.class)
                    .block();
            return new CatalogItem(recipe.getName(), rating.getRating());
        })
                .collect(Collectors.toList());
    }
}
