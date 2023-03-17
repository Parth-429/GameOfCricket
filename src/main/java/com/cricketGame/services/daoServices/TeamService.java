package com.cricketGame.services.daoServices;

import com.cricketGame.models.beans.team.Team;

import java.util.List;

public interface TeamService {
    Team addTeam(String name);
    Team findTeamById(Long id);
    List<Team> findTeamByName(String name);
}
