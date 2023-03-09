package com.CricketGame.utils;

import com.cricketGame.dto.MatchDTO;
import com.cricketGame.dto.PersonDTO;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.beans.Match;
import com.cricketGame.models.enums.MatchFormat;
import com.cricketGame.models.enums.Role;
import com.cricketGame.services.generators.ObjectIDGenerator;

import java.util.ArrayList;
import java.util.List;

public class DtoUtils {
    public static final int TEAM_SIZE = 5;
    public static final int ALLOWED_TEAM_SIZE = 5;
    public static MatchDTO getMatchDTO(){
        return new MatchDTO(getTeamDTO(), getTeamDTO(), ALLOWED_TEAM_SIZE, MatchFormat.T20);
    }

    public static PersonDTO getPersonDTO(){
        return new PersonDTO("Parth", "Prajapati", 24);
    }
    public static List<MatchDTO> getMatchList(){
        List<MatchDTO> matches = new ArrayList<>();
        matches.add(getMatchDTO());
        matches.add(getMatchDTO());
        return matches;
    }
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
}
