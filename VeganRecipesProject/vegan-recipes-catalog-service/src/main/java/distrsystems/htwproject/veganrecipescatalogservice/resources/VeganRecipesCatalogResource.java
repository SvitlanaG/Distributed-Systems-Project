package distrsystems.htwproject.veganrecipescatalogservice.resources;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import distrsystems.htwproject.veganrecipescatalogservice.models.CatalogItem;
import distrsystems.htwproject.veganrecipescatalogservice.models.Recipe;
import distrsystems.htwproject.veganrecipescatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

// get all rated recipe IDs
// For each Id, call recipe info service and get details
// put them all together

@RestController
@RequestMapping("/catalog")
public class VeganRecipesCatalogResource {

    @Autowired
    private WebClient.Builder webClientBuilder;

 /*   @Autowired
    private MyFeignClient myFeignClient;*/

    /*private final DiscoveryClient client;
    public VeganRecipesCatalogResource(DiscoveryClient client) {
        this.client = client;
    }
    private int index =0;*/


    @RequestMapping("/{userId}")
    @HystrixCommand
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

       // WebClient.Builder builder = WebClient.builder();

     /*   client.getInstancesById("service-name").get(0).getHomePageUrl();
        // load balancing manuel
        final List<InstanceInfo> instanceInfos = client.getInstancesById("name");
        int size = instanceInfos.size();
        final String url = instanceInfos.get(index++ % size).getHomePageUrl();*/


            UserRating userRating = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8083/ratingsdata/users/" + userId)
                    .retrieve()
                    .bodyToMono(UserRating.class)
                    .block();


        // call recipe info api from the catalog service
        return userRating.getUserRating().stream().map(rating -> {

            Recipe recipe = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/vegan-recipes/" + rating.getRecipeId())
                    .retrieve()
                    .bodyToMono(Recipe.class)
                    .block();
            return new CatalogItem(recipe.getName(), rating.getRating());
        })
                .collect(Collectors.toList());
    }
}








