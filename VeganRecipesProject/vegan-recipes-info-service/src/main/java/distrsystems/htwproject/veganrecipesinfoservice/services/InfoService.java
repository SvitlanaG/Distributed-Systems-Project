package distrsystems.htwproject.veganrecipesinfoservice.services;

import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;

public interface InfoService {

    public Recipe getRecipeInfo (String recipeId);
}
