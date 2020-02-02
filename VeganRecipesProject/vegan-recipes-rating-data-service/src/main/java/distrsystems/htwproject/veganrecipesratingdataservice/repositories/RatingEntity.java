package distrsystems.htwproject.veganrecipesratingdataservice.repositories;

import org.springframework.data.annotation.Id;

public class RatingEntity {

    private String recipeId;
    private int rating;

    @Id
    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
