package com.cricketGame.dtoMappers;


import com.cricketGame.dto.MatchDTO;
import com.cricketGame.models.Match;
import com.cricketGame.models.Team;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.daoServices.MatchService;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public Match toMatch(MatchDTO matchDTO){
        Long team1Id = matchDTO.getTeam1Id();
        Long team2Id = matchDTO.getTeam2Id();
        int allowedTeamSize = matchDTO.getAllowedTeamSize();
        long matchID = ObjectIDGenerator.getID();
        Team team1 = AllService.teamService.findTeamById(team1Id);
        Team team2 = AllService.teamService.findTeamById(team2Id);
        String format = matchDTO.getFormat();
        return new Match(matchID,team1,team2, allowedTeamSize, format);
    }
    public MatchDTO toDto(Match match){
        MatchDTO matchDTO = new MatchDTO();
        matchDTO.setTeam1Id(match.getTeam1().getId());
        matchDTO.setTeam2Id(match.getTeam2().getId());
        return matchDTO;
    }
}
