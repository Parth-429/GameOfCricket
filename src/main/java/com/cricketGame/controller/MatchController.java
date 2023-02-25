package com.cricketGame.controller;


import com.cricketGame.dto.MatchDTO;
import com.cricketGame.mappers.MatchMapper;
import com.cricketGame.models.beans.Match;
import com.cricketGame.services.daoServices.MatchService;
import com.cricketGame.validatorAnnotations.ValidAllowedTeamSize;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/start/{id}/") // post mapping
    public String startMatch(@PathVariable Long id){
       return matchService.checkMatchIsPlayedOrNot(id);
    }
}
