package com.cricketGame.controller;

import com.cricketGame.dto.TeamDTO;
import com.cricketGame.mappers.TeamMapper;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.models.beans.team.Team;
import com.cricketGame.services.daoServicesImpl.TeamHistoryService;
import com.cricketGame.services.daoServicesImpl.TeamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * Create Team and store it into database.
     * @param teamDTO it will create team, it needs unique team name to be passed
     * @return team info  with team name and unique team id
     * @throws java.sql.SQLDataException if team id is not unique
     */
    @PostMapping("/forMatch/")
    public ResponseEntity<TeamDTO> addTeam(@Valid @RequestBody TeamDTO teamDTO){
        TeamHistory team = teamHistoryService.saveTeam(teamDTO);
        return ResponseEntity.ok(teamMapper.toTeamDto(team));
    }

    /**
     * It will find team by their names and return list of teams that matches to given name
     * @param teamName String that contains name of team
     * @return list of teams whose name match with given parameter or else return emptyList
     */
    @GetMapping("/name/{name}/")
    public ResponseEntity<List<Team>> findPersonByName(@PathVariable(name = "name") String teamName){
        return ResponseEntity.ok(this.teamService.findTeamByName(teamName));
    }
}
