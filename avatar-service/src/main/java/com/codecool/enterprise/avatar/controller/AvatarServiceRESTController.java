package main.java.com.codecool.enterprise.avatar.controller;

import main.java.com.codecool.enterprise.avatar.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvatarServiceRESTController {

    @Autowired
    AvatarService avatarService;

    @RequestMapping(value = "/api/get_random_avatar", method = RequestMethod.GET)
    public ResponseEntity<String> getRandomAvatar() {
        return new ResponseEntity<>(avatarService.getRandomAvatar(), HttpStatus.OK);
    }

}
