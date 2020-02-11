package distrsystems.htwproject.veganrecipesinfoservice.services;

import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;
import distrsystems.htwproject.veganrecipesinfoservice.models.RecipeSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class InfoServiceImpl implements InfoService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public InfoServiceImpl() {
    }

    @Override
    public Recipe getRecipeInfo(String recipeId) {
        RecipeSummary recipeSummary = webClientBuilder.build()
                .get()
                .uri("https://api.spoonacular.com/recipes/" + recipeId + "/information/?apiKey=" + apiKey)
                .retrieve()
                .bodyToMono(RecipeSummary.class)
                .block();
        return new Recipe(recipeId, recipeSummary.getTitle(), recipeSummary.getImage(), recipeSummary.getSourceUrl());
    }
}
