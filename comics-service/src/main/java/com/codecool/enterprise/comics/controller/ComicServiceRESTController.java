package com.codecool.enterprise.comics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicServiceRESTController {

    @Autowired
    ComicService comicService;

    @RequestMapping(value = "/api/get_random_img", method = RequestMethod.GET)
    public ResponseEntity<String> getRandomComic() {
        return new ResponseEntity<>(comicService.getRandomComic(), HttpStatus.OK);
    }
}
