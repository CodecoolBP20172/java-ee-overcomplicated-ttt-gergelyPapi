package main.java.com.codecool.enterprise.tictactoeai.controller;

import main.java.com.codecool.enterprise.tictactoeai.service.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TicTacToeAiRESTController {

    @Autowired
    TicTacToeService ticTacToeService;

    @CrossOrigin
    @RequestMapping(value = "/api/player_step", method = RequestMethod.POST)
    public ResponseEntity<Integer> playerStep(@RequestBody Map<String, String> data) {
        return new ResponseEntity<>(
                ticTacToeService.getCellForAiStep (data),
                HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/ai_step", method = RequestMethod.POST)
    public ResponseEntity<String> aiStep(@RequestBody Map<String, String> data) {
        ticTacToeService.addToAiStepList(Integer.parseInt(data.get("aiSelectedCell")));
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/api/check_winning_condition", method = RequestMethod.GET)
    public ResponseEntity<String> winningConditionCheck() {
        return new ResponseEntity<>(ticTacToeService.checkWinningCondition(), HttpStatus.OK);
    }



}
