package distrsystems.htwproject.veganrecipesinfoservice.services;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import distrsystems.htwproject.veganrecipesinfoservice.models.Recipe;
import distrsystems.htwproject.veganrecipesinfoservice.models.RecipeSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class InfoServiceImpl implements InfoService {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public InfoServiceImpl() {
    }

    @Override
    public Recipe getRecipeInfo(String recipeId) {
        HystrixCommandGroupKey key = HystrixCommandGroupKey.Factory.asKey("INFOSERVICE");

       HystrixCommand<Recipe> command = new GetRecipeCommand(webClientBuilder, recipeId, key, apiKey);

       return command.execute();
    }
}
