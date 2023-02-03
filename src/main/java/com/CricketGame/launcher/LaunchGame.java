package com.cricketGame.launcher;

import com.cricketGame.services.StartGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaunchGame {

	public static void main(String[] args) {
		StartGame gameLauncher = new StartGame();
		gameLauncher.startGame();
	}
}
