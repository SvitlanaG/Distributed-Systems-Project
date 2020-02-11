package distrsystems.htwproject.veganrecipescatalogservice.controllers;

import distrsystems.htwproject.veganrecipescatalogservice.models.CatalogItem;
import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;
import distrsystems.htwproject.veganrecipescatalogservice.services.RecipeClient;
import distrsystems.htwproject.veganrecipescatalogservice.services.UserRatingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private UserRatingClient userRatingClient;

    @Autowired
    private RecipeClient recipeClient;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        UserRating userRating = userRatingClient.getUserRatig(userId);

        return recipeClient.getRecipes(userRating);
    }
}
