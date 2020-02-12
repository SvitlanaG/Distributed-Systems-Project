
package distrsystems.htwproject.veganrecipescatalogservice.resources;


import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("vegan-recipes-catalog-service")
public interface MyFeignClient {

    @GetMapping("/catalog/{userId}")
    UserRating clientVeganRecipesCatalogServiceResponse(@PathVariable String userId);
}

