package com.cricketGame;

import com.cricketGame.services.gameStarter.matchStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaunchGame {
	public static void main(String[] args) {
		SpringApplication.run(LaunchGame.class,args);
		matchStarter.startGame();
	}
}
