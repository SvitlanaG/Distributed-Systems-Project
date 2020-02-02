package distrsystems.htwproject.veganrecipescatalogservice.service;

import distrsystems.htwproject.veganrecipescatalogservice.models.CatalogItem;
import distrsystems.htwproject.veganrecipescatalogservice.models.Recipe;
import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;

import java.util.List;

public interface RecipeClient {

    public List<CatalogItem> getRecipes(UserRating userRating);
}
