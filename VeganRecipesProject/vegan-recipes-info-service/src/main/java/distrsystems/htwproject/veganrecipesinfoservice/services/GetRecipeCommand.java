package distrsystems.htwproject.veganrecipesinfoservice.services;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;
import distrsystems.htwproject.veganrecipesinfoservice.models.RecipeSummary;
import org.springframework.web.reactive.function.client.WebClient;

public class GetRecipeCommand extends HystrixCommand<Recipe> {
    private final String recipeId;
    private final String apiKey;
    private WebClient.Builder webClientBuilder;


    public GetRecipeCommand(WebClient.Builder clientBuilder, String recipeId, HystrixCommandGroupKey group, String apiKey) {
        super(group);
        this.webClientBuilder = clientBuilder;
        this.recipeId = recipeId;
        this.apiKey = apiKey;
    }

    @Override
    protected Recipe run() throws Exception {
        RecipeSummary recipeSummary = webClientBuilder.build()
                .get()
                .uri("https://api.spoonacular.com/recipes/" + recipeId + "/information/?apiKey=" + apiKey)
                .retrieve()
                .bodyToMono(RecipeSummary.class)
                .block();
        return new Recipe(recipeId, recipeSummary.getTitle(), recipeSummary.getImage(), recipeSummary.getSourceUrl());
    }

    @Override
    protected Recipe getFallback() {
        return new Recipe(recipeId, "n/a", "n/a", "n/a");
    }
}
