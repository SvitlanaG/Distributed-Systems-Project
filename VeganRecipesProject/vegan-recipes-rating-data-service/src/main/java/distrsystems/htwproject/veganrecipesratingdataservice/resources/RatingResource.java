package distrsystems.htwproject.veganrecipesratingdataservice.resources;

import distrsystems.htwproject.veganrecipesratingdataservice.models.Rating;
import distrsystems.htwproject.veganrecipesratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{recipeId}")
    public Rating getRating(@PathVariable("recipeId") String recipeId) {
        return new Rating(recipeId, 3);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
