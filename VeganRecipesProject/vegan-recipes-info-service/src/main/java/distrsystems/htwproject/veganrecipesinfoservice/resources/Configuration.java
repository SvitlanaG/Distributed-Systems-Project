package distrsystems.htwproject.veganrecipesinfoservice.resources;


import distrsystems.htwproject.veganrecipesinfoservice.services.InfoService;
import distrsystems.htwproject.veganrecipesinfoservice.services.InfoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder();
    }

    @Bean
    public InfoService infoService() {
        return new InfoServiceImpl();
    }
}
