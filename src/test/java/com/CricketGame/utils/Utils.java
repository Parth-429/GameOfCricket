package com.CricketGame.utils;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.beans.Innings;
import com.cricketGame.models.beans.Match;
import com.cricketGame.models.beans.player.Batsman;
import com.cricketGame.models.beans.player.Bowler;
import com.cricketGame.models.beans.player.Person;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.models.beans.team.Team;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.models.enums.MatchFormat;
import com.cricketGame.models.enums.Role;
import com.cricketGame.services.generators.ObjectIDGenerator;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final int TEAM_SIZE = 5;
    public static PlayerDTO getPlayerDTO(Role role, int battingOrderNo){
        return new PlayerDTO(ObjectIDGenerator.getID(), role, battingOrderNo);
    }
    public static List<PlayerDTO> getListOfPlayerDTOs(int teamSize){
        List<PlayerDTO> playerDTOS = new ArrayList<>();
        int orderNo = 1;
        for(int i =0; i<teamSize; i++){
             playerDTOS.add(getPlayerDTO(Role.BOWLER, orderNo++));
        }
        return playerDTOS;
    }
    public static TeamDTO getTeamDTO(){
        return new TeamDTO(ObjectIDGenerator.getID(), TEAM_SIZE, getListOfPlayerDTOs(TEAM_SIZE));
    }
    public static MatchDTO getMatchDTO(){
       return new MatchDTO(getTeamDTO(), getTeamDTO(), TEAM_SIZE, MatchFormat.T20);
    }

    public static Person getPerson(String firstName, String lastName, int age) {
        return new Person(ObjectIDGenerator.getID(), firstName, lastName, age);
    }
    public static Player getBowler(int orderNo){
        return new Bowler(ObjectIDGenerator.getID(), getPerson("Parth", "Prajapati", 25), orderNo);
    }

    public static Player getBatsman(int orderNo){
        return new Batsman(ObjectIDGenerator.getID(), getPerson("Parth", "Prajapati", 25), orderNo);
    }

    public static Team getTeam(String name){
        return new Team(ObjectIDGenerator.getID(), name);
    }
    public static List<Player> getPlayerList(int teamSize){
        List<Player> players = new ArrayList<>();
        int orderNo = 1;
        for(int i =0; i<teamSize; i++){
            players.add(getBowler(orderNo++));
        }
        return players;
    }
    public static TeamHistory getTeamHistory(String name){
        return new TeamHistory(ObjectIDGenerator.getID(), getTeam(name), getPlayerList(TEAM_SIZE), TEAM_SIZE);
    }

    public static Match getMatch(String team1Name, String team2Name){
        return new Match(ObjectIDGenerator.getID(),getTeamHistory(team1Name), getTeamHistory(team2Name), TEAM_SIZE,
                MatchFormat.T20);
    }

    public static Innings getInnings(){
        return new Innings(getTeamHistory("TeamX"), getTeamHistory("TeamY"));
    }

}
