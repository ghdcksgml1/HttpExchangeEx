package com.httpexchange.hc.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Getter
@NoArgsConstructor
public class ExternalApiResponse {
    private String result;
    private Map<String, Double> rates;

    @Builder
    private ExternalApiResponse(String result, Map<String, Double> rates) {
        this.result = result;
        this.rates = rates;
    }
}
