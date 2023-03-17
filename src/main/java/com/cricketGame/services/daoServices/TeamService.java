package com.cricketGame.services.daoServices;

import com.cricketGame.models.beans.team.Team;

import java.util.List;

public interface TeamService {
    List<Team> findTeamByName(String name);
    Team findTeamById(Long id);
}
