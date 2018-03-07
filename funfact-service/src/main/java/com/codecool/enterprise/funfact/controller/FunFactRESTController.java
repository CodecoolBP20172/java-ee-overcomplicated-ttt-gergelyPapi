package com.codecool.enterprise.funfact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunFactRESTController {

    @Autowired
    FunFactService funFactService;

    @RequestMapping(value = "/api/get_random_quote", method = RequestMethod.GET)
    public ResponseEntity<String> getFunFact() {
        return new ResponseEntity<>(funFactService.getFunFact(), HttpStatus.OK);
    }
}
