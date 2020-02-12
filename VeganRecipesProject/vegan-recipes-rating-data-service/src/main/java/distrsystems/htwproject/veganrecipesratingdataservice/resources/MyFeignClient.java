
package distrsystems.htwproject.veganrecipesratingdataservice.resources;


import distrsystems.htwproject.veganrecipesratingdataservice.models.UserRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("vegan-recipes-rating-data-service")
public interface MyFeignClient {

    @GetMapping("/rating/list")
    UserRating clientVeganRecipesRatingDataServiceResponse();
}

