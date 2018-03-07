package com.codecool.enterprise.funfact.controller;

import com.codecool.enterprise.comics.model.Comic;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class ComicService {

    public String getRandomComic () {

        Random random = new Random();
        int randomImgNumber = random.nextInt(1929) + 1;

        final String uri = "https://xkcd.com/" + randomImgNumber + "/info.0.json";

        RestTemplate restTemplate = new RestTemplate();
        Comic result = restTemplate.getForObject(uri, Comic.class);

        return result.getImg();
    }

}
