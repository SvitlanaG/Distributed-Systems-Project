package distrsystems.htwproject.veganrecipescatalogservice.services;

import distrsystems.htwproject.veganrecipescatalogservice.models.CatalogItem;
import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;

import java.util.List;

public interface RecipeClient {

    public List<CatalogItem> getRecipes(UserRating userRating);
}
