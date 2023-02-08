package com.cricketGame.launcher;

import com.cricketGame.services.GameLauncher;
import com.cricketGame.view.ShowScoreCard;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaunchGame {

	public static void main(String[] args) {
		GameLauncher.startGame();
	}
}
