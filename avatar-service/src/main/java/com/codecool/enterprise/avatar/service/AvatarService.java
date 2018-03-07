package main.java.com.codecool.enterprise.avatar.service;

import main.java.com.codecool.enterprise.avatar.model.Avatar;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AvatarService {

    public String getRandomAvatar () {

        Avatar result = new Avatar();
        result.setRandomizedString("https://api.adorable.io/avatars/285/" + randomString() + ".png");

        return result.getRandomizedString();
    }

    private String randomString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
}
