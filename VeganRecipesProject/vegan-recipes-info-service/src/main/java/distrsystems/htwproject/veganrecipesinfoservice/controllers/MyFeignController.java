package distrsystems.htwproject.veganrecipesinfoservice.controllers;


import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;
import distrsystems.htwproject.veganrecipesinfoservice.resources.MyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class MyFeignController {

    final MyFeignClient myFeignClient;

    @Autowired
    public MyFeignController(MyFeignClient myFeignClient) {
        this.myFeignClient = myFeignClient;
    }

    @RequestMapping("/vegan-recipes/{recipeId}")
    public Recipe clientVeganRecipesCatalogServiceResponse(@PathVariable("recipeId") String recipeId) {
        return myFeignClient.clientVeganRecipesInfoServiceResponse(recipeId);
    }
}
