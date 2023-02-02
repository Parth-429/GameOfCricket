package com.CricketGame.GameOfCricket;

import com.CricketGame.Services.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameOfCricketApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameOfCricketApplication.class, args);
		Game game = new Game();
		game.Start();
	}
}
