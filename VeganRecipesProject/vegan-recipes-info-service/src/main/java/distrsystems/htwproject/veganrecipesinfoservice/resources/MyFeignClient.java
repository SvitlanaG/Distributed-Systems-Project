
package distrsystems.htwproject.veganrecipesinfoservice.resources;


import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("vegan-recipes-info-service")
public interface MyFeignClient {

    @GetMapping("/vegan-recipes/{recipeId}")
    Recipe clientVeganRecipesInfoServiceResponse(@PathVariable String recipeId);
}

