package com.cricketGame;

import com.cricketGame.services.daoServices.BatsmanStatsService;
import com.cricketGame.services.gameStarter.matchStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class LaunchGame {
	public static void main(String[] args) {
		SpringApplication.run(LaunchGame.class,args);
//		ApplicationContext context = new AnnotationConfigApplicationContext("com/cricketGame");
////		BatsmanStatsService batsmanStatsService = context.getBean(BatsmanStatsService.class);
////		System.out.println(batsmanStatsService);
		matchStarter.startGame();
	}
}
