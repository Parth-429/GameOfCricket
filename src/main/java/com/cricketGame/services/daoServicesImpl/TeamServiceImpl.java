package com.cricketGame.services.daoServicesImpl;


import com.cricketGame.models.beans.team.Team;
import com.cricketGame.repository.TeamRepository;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamServiceImpl implements com.cricketGame.services.daoServices.TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team addTeam(String name) {
        Long teamID = ObjectIDGenerator.getID();
        Team team = new Team(teamID, name);
        return this.teamRepository.save(team);
    }

    public Team findTeamById(Long id) {
        Optional<Team> checkTeam = this.teamRepository.findById(id);
        return checkTeam.orElse(null);
    }

    public List<Team> findTeamByName(String name) {
        List<Team> teams = teamRepository.findByName(name);
        if (Objects.isNull(teams)) {
            return Collections.emptyList();
        }
        return teams;
    }
}
