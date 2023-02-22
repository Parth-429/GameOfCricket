package com.cricketGame.dtoMappers;


import com.cricketGame.dto.MatchDTO;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.Match;
import com.cricketGame.models.TeamHistory;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public Match toMatch(MatchDTO matchDTO){
        TeamDTO team1DTO = matchDTO.getTeam1DTO();
        TeamDTO team2DTO = matchDTO.getTeam2DTO();
        int allowedTeamSize = matchDTO.getAllowedTeamSize();
        long matchID = ObjectIDGenerator.getID();
        String format = matchDTO.getFormat();
        TeamHistory team1 = AllService.teamService.saveTeam(team1DTO);
        TeamHistory team2 = AllService.teamService.saveTeam(team2DTO);
        return new Match(matchID,team1,team2, allowedTeamSize, format);
    }
    public MatchDTO toDto(Match match){
        MatchDTO matchDTO = new MatchDTO();
        return matchDTO;
    }
}
