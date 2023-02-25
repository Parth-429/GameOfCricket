package com.cricketGame.controller;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.mappers.TeamMapper;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.models.beans.team.Team;
import com.cricketGame.services.daoServices.TeamHistoryService;
import com.cricketGame.services.daoServices.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamHistoryService teamHistoryService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamMapper teamMapper;
    @PostMapping("/")
    public Team addTeam(@Valid @RequestBody String name){
        return this.teamService.addTeam(name);
    }
    @PostMapping("/forMatch/")
    public ResponseEntity<TeamDTO> addTeam(@Valid @RequestBody TeamDTO teamDTO){
        TeamHistory team = teamHistoryService.saveTeam(teamDTO);
        return ResponseEntity.ok(teamMapper.toTeamDto(team));
    }
}
