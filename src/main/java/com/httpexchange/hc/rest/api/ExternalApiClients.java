package com.httpexchange.hc.rest.api;

import com.httpexchange.hc.common.ExternalClients;
import com.httpexchange.hc.rest.dto.ExternalApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.service.annotation.GetExchange;

@ExternalClients(baseUrl = "http://localhost:8080")
public interface ExternalApiClients {

    @GetExchange(value = "/v6/latest")
    public ExternalApiResponse getLatest();

}
