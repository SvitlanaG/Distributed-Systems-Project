package distrsystems.htwproject.veganrecipesinfoservice.resources;

import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vegan-recipes")
public class VeganRecipesResource {

    @RequestMapping("/{recipeId}")
    public Recipe getRecipeInfo(@PathVariable("recipeId") String recipeId) {
        return new Recipe(recipeId, "01");
    }
}
