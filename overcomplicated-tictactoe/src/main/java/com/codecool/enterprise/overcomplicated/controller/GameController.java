package com.codecool.enterprise.overcomplicated.controller;

import com.codecool.enterprise.overcomplicated.model.Player;
import com.codecool.enterprise.overcomplicated.model.TictactoeGame;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"player", "game"})
public class GameController {

    @ModelAttribute("player")
    public Player getPlayer() {
        return new Player();
    }

    @ModelAttribute("game")
    public TictactoeGame getGame() {
        return new TictactoeGame();
    }

    @ModelAttribute("avatar_uri")
    public String getAvatarUri() {
        return "https://robohash.org/codecool";
    }

    @GetMapping(value = "/")
    public String welcomeView(@ModelAttribute Player player) {
        return "welcome";
    }

    @PostMapping(value="/changeplayerusername")
    public String changPlayerUserName(@ModelAttribute Player player) {
        return "redirect:/game";
    }

    @RequestMapping(value = "/game",  method = RequestMethod.GET)
    public String gameView(@ModelAttribute("player") Player player, Model model, HttpSession session) {

        final String uriForQuote = "http://localhost:60003/api/get_random_quote";
        RestTemplate restTemplate = new RestTemplate();
        String quote = restTemplate.getForObject(uriForQuote, String.class);
        System.out.println(quote);

        final String uriForImg = "http://localhost:60002/api/get_random_img";
        RestTemplate restTemplateImg = new RestTemplate();
        String img = restTemplateImg.getForObject(uriForImg, String.class);
        System.out.println(img);

        final String uriForAvatar = "http://localhost:60001/api/get_random_avatar";
        RestTemplate restTemplateAvatar = new RestTemplate();
        String randomAvatarURI = restTemplateAvatar.getForObject(uriForAvatar, String.class);
        System.out.println(randomAvatarURI);

        model.addAttribute("funfact", "&quot;" + quote + "&quot;");
        model.addAttribute("comic_uri", img);
        session.setAttribute("avatar_uri", randomAvatarURI);
        return "game";
    }

    @GetMapping(value = "/game-move")
    public String gameMove(@ModelAttribute("player") Player player, @ModelAttribute("move") int move) {
        System.out.println("Player moved " + move);
        return "redirect:/game";
    }
}
