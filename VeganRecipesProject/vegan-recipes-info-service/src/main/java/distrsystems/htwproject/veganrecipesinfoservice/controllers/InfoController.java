package distrsystems.htwproject.veganrecipesinfoservice.controllers;


import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;
import distrsystems.htwproject.veganrecipesinfoservice.services.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vegan-recipes")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/{recipeId}")
    public Recipe getRecipeInfo(@PathVariable("recipeId") String recipeId) {

        return infoService.getRecipeInfo(recipeId);
    }
}
