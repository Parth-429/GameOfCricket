package com.cricketGame.controller;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.dtoMappers.TeamMapper;
import com.cricketGame.models.TeamHistory;
import com.cricketGame.models.Team;
import com.cricketGame.services.daoServices.TeamService;
import com.cricketGame.services.daoServices._TeamService;
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
    private _TeamService _teamService;
    @Autowired
    private TeamMapper teamMapper;

    @PostMapping
    public Team addTeam(@RequestBody String name){
        return this._teamService.addTeam(name);
    }
    @PostMapping("/forMatch")
    public TeamDTO addTeam(@RequestBody TeamDTO teamDTO){
        TeamHistory team = teamService.saveTeam(teamDTO);
        return teamMapper.toDto(team);
    }
}
