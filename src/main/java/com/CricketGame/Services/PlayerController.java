package com.CricketGame.Services;

import com.CricketGame.Entities.BatsmanHistory;
import com.CricketGame.Entities.Player;

import java.util.Scanner;

public class PlayerController {
    public Player createPlayer(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Name of Player : \n");
        String name = sc.next();

        System.out.println("What is the Speciality of Player [Bowler / Batsman / All-Rounder]: \n");
        String type = sc.next();

        if(type.equals("Bowler") || type.equals("Batsman") || type.equals("All-Rounder"))
            type = "Bowler";

        Player.Builder builder = new Player.Builder(name,type);
        return builder.setBattingStyle("Right-ARM").setBallingStyle("Faster").SaveDetails();
    }

    public void updatePlayer(Player player, Integer match_id){
        UpdateBatsman updater = new UpdateBatsman(player);
        BatsmanHistory history = player.getBatsman().getMatchWiseHistory(match_id);
        updater.update(history.getRuns(), history.getBalls(), history.getSix(), history.getFours());
    }
}
