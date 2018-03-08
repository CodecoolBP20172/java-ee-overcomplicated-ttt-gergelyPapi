package main.java.com.codecool.enterprise.tictactoeai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TicTacToeAiServiceApplication {
    
    public static void main (String [] args) {
        
        SpringApplication.run(TicTacToeAiServiceApplication.class, args);
        
    }
    
}
