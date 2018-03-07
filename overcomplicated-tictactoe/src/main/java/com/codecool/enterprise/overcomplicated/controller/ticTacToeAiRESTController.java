package com.codecool.enterprise.overcomplicated.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ticTacToeAiRESTController {

    @RequestMapping(value = "/game-move?move={cellId}", method = RequestMethod.POST)
    public ResponseEntity<String> deleteFoodFromOrder(@PathVariable("cellId") int cellId) {
        System.out.println(cellId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
