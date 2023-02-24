package com.cricketGame.services.daoServices;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.mappers.TeamMapper;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.repository.TeamHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamHistoryService {

    @Autowired
    private TeamHistoryRepository teamHistoryRepository;
    @Autowired
    private TeamMapper teamMapper;
    public TeamHistory saveTeam(TeamDTO teamDTO){
        TeamHistory team = teamMapper.toTeam(teamDTO);
        return this.teamHistoryRepository.save(team);
    }
    public TeamHistory findTeamById(Long id){
        Optional<TeamHistory> checkTeam = this.teamHistoryRepository.findById(id);
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
