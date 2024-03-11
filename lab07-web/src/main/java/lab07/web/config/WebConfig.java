package lab07.web.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import java.util.stream.DoubleStream;

@Configuration
public class WebConfig {

    @Value("${lab07.api.root}")
    public String apiRoot;

    @Bean
    public RestClient restclient(){
        return RestClient.builder().baseUrl(apiRoot).build();
    }




}
