package com.cricketGame.services.daoServices;


import com.cricketGame.models.beans.team.Team;
import com.cricketGame.repository.TeamRepository;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public Team addTeam(String name){
        Long teamID = ObjectIDGenerator.getID();
        Team team = new Team(teamID, name);
        return this.teamRepository.save(team);
    }
    public Team findTeamById(Long id){
        Optional<Team> checkTeam = this.teamRepository.findById(id);
        return checkTeam.orElse(null);
    }
}
