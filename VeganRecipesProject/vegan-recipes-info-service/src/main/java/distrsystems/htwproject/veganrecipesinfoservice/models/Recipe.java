package distrsystems.htwproject.veganrecipesinfoservice.models;

public class Recipe {

    private String recipeId;
    private String name;

    public Recipe(String recipeId, String name) {
        this.recipeId = recipeId;
        this.name = name;
    }

    public Recipe() {
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
