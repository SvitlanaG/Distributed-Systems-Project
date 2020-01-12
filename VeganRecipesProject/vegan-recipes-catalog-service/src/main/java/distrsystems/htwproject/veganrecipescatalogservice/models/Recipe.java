package distrsystems.htwproject.veganrecipescatalogservice.models;

public class Recipe {

    private String recipeId;
    private String name;
    //private String desc;

    public Recipe() {

    }

    public Recipe(String recipeId, String name) {
        this.recipeId = recipeId;
        this.name = name;
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
