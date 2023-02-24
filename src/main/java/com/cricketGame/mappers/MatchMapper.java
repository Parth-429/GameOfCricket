package com.cricketGame.mappers;


import com.cricketGame.constants.Constants;
import com.cricketGame.dto.MatchDTO;
import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.beans.Match;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {
    @Autowired
    private TeamMapper teamMapper;
    public Match toMatch(MatchDTO matchDTO){
        TeamDTO team1DTO = matchDTO.getTeam1DTO();
        TeamDTO team2DTO = matchDTO.getTeam2DTO();
        int allowedTeamSize = matchDTO.getAllowedTeamSize();
        long matchID = ObjectIDGenerator.getID();
        String format = matchDTO.getFormat();
        TeamHistory team1 = AllService.teamHistoryService.saveTeam(team1DTO);
        TeamHistory team2 = AllService.teamHistoryService.saveTeam(team2DTO);
        return new Match(matchID,team1,team2, allowedTeamSize, format);
    }
    public MatchDTO toMatchDto(Match match){
        MatchDTO matchDTO = new MatchDTO();
        TeamDTO team1DTO = teamMapper.toTeamDto(match.getTeam1());
        TeamDTO team2DTO = teamMapper.toTeamDto(match.getTeam2());
        matchDTO.setTeam1DTO(team1DTO);
        matchDTO.setTeam2DTO(team2DTO);
        matchDTO.setFormat(match.getFormat().toString());
        matchDTO.setAllowedTeamSize(Constants.ALLOWED_TEAM_SIZE);
        return matchDTO;
    }
}
