package com.codecool.enterprise.funfact.controller;

import com.codecool.enterprise.funfact.model.FunFact;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunFactService {

    public String getFunFact () {

        final String uri = "https://talaikis.com/api/quotes/random/";

        RestTemplate restTemplate = new RestTemplate();
        FunFact result = restTemplate.getForObject(uri, FunFact.class);

        return result.getQuote();
    }
}
