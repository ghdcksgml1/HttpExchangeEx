package com.httpexchange.hc.config;

import com.httpexchange.hc.rest.api.ExternalApiClients;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class AppConfig {

    @Bean
    public ExternalApiClients externalApiClients() {
        WebClient webClient = WebClient.builder().baseUrl("https://open.er-api.com").build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

        ExternalApiClients externalService = factory.createClient(ExternalApiClients.class);

        return externalService;
    }
}
