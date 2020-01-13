package distrsystems.htwproject.veganrecipesinfoservice.resources;

import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;
import distrsystems.htwproject.veganrecipesinfoservice.models.RecipeSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/vegan-recipes")
public class VeganRecipesResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{recipeId}")
    public Recipe getRecipeInfo(@PathVariable("recipeId") String recipeId) {
        RecipeSummary recipeSummary = webClientBuilder.build()
                .get()
                .uri("https://api.spoonacular.com/recipes/" + recipeId + "/information/?apiKey=" + apiKey)
                .retrieve()
                .bodyToMono(RecipeSummary.class)
                .block();
        return new Recipe(recipeId, recipeSummary.getTitle());
    }

    //public Recipe getRecipeInfo(@PathVariable("recipeId") String recipeId) {
      //  return new Recipe(recipeId, "01");
    //}
}
