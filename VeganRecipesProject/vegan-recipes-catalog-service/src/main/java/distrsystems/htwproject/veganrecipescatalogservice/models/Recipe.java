package distrsystems.htwproject.veganrecipescatalogservice.models;

public class Recipe {

    private String recipeId;
    private String name;
    private String desc;

    public Recipe() {

    }

    public Recipe(String recipeId, String name, String desc) {
        this.recipeId = recipeId;
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
