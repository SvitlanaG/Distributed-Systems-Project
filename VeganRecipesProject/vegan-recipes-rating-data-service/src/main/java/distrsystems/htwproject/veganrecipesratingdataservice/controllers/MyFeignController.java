package distrsystems.htwproject.veganrecipesratingdataservice.controllers;


import distrsystems.htwproject.veganrecipesratingdataservice.models.UserRating;
import distrsystems.htwproject.veganrecipesratingdataservice.resources.MyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class MyFeignController {

    final MyFeignClient myFeignClient;

    @Autowired
    public MyFeignController(MyFeignClient myFeignClient) {
        this.myFeignClient = myFeignClient;
    }

    @RequestMapping("/rating/list")
    public UserRating clientVeganRecipesCatalogServiceResponse() {
        return myFeignClient.clientVeganRecipesRatingDataServiceResponse();
    }
}
