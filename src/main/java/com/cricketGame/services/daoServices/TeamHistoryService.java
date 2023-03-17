package com.cricketGame.services.daoServices;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.models.beans.team.TeamHistory;

public interface TeamHistoryService {
    TeamHistory saveTeam(TeamDTO teamDTO);
    TeamHistory findTeamById(Long id);
}
