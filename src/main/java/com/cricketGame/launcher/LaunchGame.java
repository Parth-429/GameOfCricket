package com.cricketGame.launcher;

import com.cricketGame.services.gameStarter.matchStarter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaunchGame {
	public static void main(String[] args) {
		matchStarter.startGame();
	}
}
