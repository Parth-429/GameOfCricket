package com.cricketGame.controller;


import com.cricketGame.dto.MatchDTO;
import com.cricketGame.dtoMappers.MatchMapper;
import com.cricketGame.models.Match;
import com.cricketGame.services.daoServices.MatchService;
import com.cricketGame.services.gameStarter.MatchStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private MatchMapper matchMapper;
    @PostMapping
    public MatchDTO addMatch(@RequestBody MatchDTO matchDTO){
        Match match = matchService.saveMatch(matchDTO);
        return matchMapper.toDto(match);
    }
    @GetMapping("/start/{id}")
    public String startMatch(@PathVariable Long id){
       return matchService.checkMatchIsPlayedOrNot(id);
    }
}