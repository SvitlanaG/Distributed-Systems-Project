package distrsystems.htwproject.veganrecipescatalogservice.controllers;


import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;
import distrsystems.htwproject.veganrecipescatalogservice.resources.MyFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class MyFeignController {

    final MyFeignClient myFeignClient;

    @Autowired
    public MyFeignController (MyFeignClient myFeignClient) {
        this.myFeignClient = myFeignClient;
    }

    @RequestMapping("/catalog/{userId}")
    public UserRating clientVeganRecipesCatalogServiceResponse(@PathVariable("userId") String userId) {
        return myFeignClient.clientVeganRecipesCatalogServiceResponse(userId);
    }
}
