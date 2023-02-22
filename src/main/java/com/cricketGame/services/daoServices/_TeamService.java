package com.cricketGame.services.daoServices;


import com.cricketGame.models.Team;
import com.cricketGame.models._Team;
import com.cricketGame.repository._TeamRepository;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class _TeamService {
    @Autowired
    private _TeamRepository teamRepository;
    public _Team addTeam(String name){
        Long teamID = ObjectIDGenerator.getID();
        _Team team = new _Team(teamID, name);
        return this.teamRepository.save(team);
    }
    public _Team findTeamById(Long id){
        Optional<_Team> checkTeam = this.teamRepository.findById(id);
        try {
            if (!checkTeam.isPresent())
                throw new IllegalArgumentException("Error : Team with given id is not exist");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return checkTeam.get();
    }
}
