package com.CricketGame.Services;

import com.CricketGame.Entities.BatsmanHistory;
import com.CricketGame.Entities.Player;
import com.CricketGame.Entities.Team;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeamManager {
    public Team CreateNewTeam(){
        System.out.println("Let's Create a Team: \n");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        Team team =new Team.Builder(name).SaveDetails();
        System.out.println("How many Players are there in team: \n");
        Integer totalPlayers = sc.nextInt();
        team.setPlayers(AddPlayers(totalPlayers));
        return team;
    }

    public void AddPlayer(ArrayList<Player> players){
        PlayerController playerCreater = new PlayerController();
        Player player = playerCreater.createPlayer();
        players.add(player);
    }
    public List<Player> AddPlayers(Integer noOfPlayers){
        ArrayList<Player> players = new ArrayList<>();
        for(int i=0; i<noOfPlayers; i++){
            AddPlayer(players);
        }
        return players;
    }

    public List<Player> ChoosePlayersAndSetOrderNumber(Team team, Integer match_id){
        //For Now
        List<Player> choosen = new ArrayList<>(team.getPlayers().size());
        List<Boolean> orders = new ArrayList<>(choosen.size());
        Scanner sc = new Scanner(System.in);
        for(Player player: team.getPlayers()){
            System.out.println("Choose Order Number for " + player.getName() + "[1-"+ choosen.size() + "]\n");
            Boolean isValid = false;
            while(isValid) {
                Integer order = sc.nextInt();
                if(!orders.get(order-1))
                {
                    player.getBatsman().addMatchWiseHistory(match_id, order);
                    choosen.set(order-1,player);
                    isValid = true;
                    orders.set(order-1,true);
                }
                else
                    System.out.println("This OrderNumber Already taken, Enter Another: \n");
            }
        }
        return team.getPlayers();
    }

}
