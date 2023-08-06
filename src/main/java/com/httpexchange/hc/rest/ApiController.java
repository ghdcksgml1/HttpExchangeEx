package com.httpexchange.hc.rest;

import com.httpexchange.hc.rest.api.ExternalApiClients;
import com.httpexchange.hc.rest.dto.ExternalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ExternalApiClients externalService;

    @GetMapping("/")
    public ExternalApiResponse hello() {

        return externalService.getLatest();
    }

}
