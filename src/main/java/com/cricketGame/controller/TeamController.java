package com.cricketGame.controller;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.dtoMappers.TeamMapper;
import com.cricketGame.models.Team;
import com.cricketGame.repository.TeamRepository;
import com.cricketGame.services.daoServices.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamMapper teamMapper;
    @PostMapping
    public TeamDTO addTeam(@RequestBody TeamDTO teamDTO){
        Team team = teamService.saveTeam(teamDTO);
        return teamMapper.toDto(team);
    }
}
