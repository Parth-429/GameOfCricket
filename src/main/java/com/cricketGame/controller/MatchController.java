package com.cricketGame.controller;


import com.cricketGame.dto.MatchDTO;
import com.cricketGame.mappers.MatchMapper;
import com.cricketGame.models.beans.Match;
import com.cricketGame.services.daoServices.MatchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private MatchMapper matchMapper;
    @PostMapping("/")
    public ResponseEntity<MatchDTO> addMatch(@Valid @RequestBody MatchDTO matchDTO){
        Match match = matchService.saveMatch(matchDTO);
        return ResponseEntity.ok(matchMapper.toMatchDto(match));
    }
    @PostMapping("/start/{id}/")
    public String startMatch(@PathVariable Long id){
       return matchService.checkMatchIsPlayedOrNot(id);
    }

    @GetMapping("/playedMatches/{team_id}/")
    public ResponseEntity<List<MatchDTO>> findMatchesPlayedByTeam(@PathVariable Long teamId){
        return ResponseEntity.ok(matchService.findMatchPlayedByTeamById(teamId));
    }
}
