package distrsystems.htwproject.veganrecipescatalogservice.models;

public class CatalogItem {

    private String name;
    private String image;
    private String sourceUrl;
   // private String desc;
    private int rating;

    public CatalogItem(String name, String image, String sourceUrl, int rating) {
        this.name = name;
        this.image = image;
        this.sourceUrl = sourceUrl;
      //  this.desc = desc;
        this.rating = rating;
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

  /*  public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }*/

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
