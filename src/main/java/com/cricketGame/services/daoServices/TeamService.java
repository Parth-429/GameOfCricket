package com.cricketGame.services.daoServices;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.dtoMappers.TeamMapper;
import com.cricketGame.models.Team;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.player.Player;
import com.cricketGame.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMapper teamMapper;
    public Team saveTeam(TeamDTO teamDTO){
        Team team = teamMapper.toTeam(teamDTO);
        return this.teamRepository.save(team);
    }
    public Team findTeamById(Long id){
        Optional<Team> checkTeam = this.teamRepository.findById(id);
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
