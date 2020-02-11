package distrsystems.htwproject.veganrecipesinfoservice.models;

public class Recipe {

    private String recipeId;
    private String name;
    private String image;
    private String sourceUrl;

    public Recipe(String recipeId, String name, String image, String sourceUrl) {
        this.recipeId = recipeId;
        this.name = name;
        this.image = image;
        this.sourceUrl = sourceUrl;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

}
