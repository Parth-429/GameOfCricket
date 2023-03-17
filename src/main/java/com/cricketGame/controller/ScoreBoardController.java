package com.cricketGame.controller;

import com.cricketGame.models.beans.Match;
import com.cricketGame.services.daoServices.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scoreboard")
public class ScoreBoardController {
    @Autowired
    private MatchService matchService;

    /**
     *  It retursn scorecard of match
     * @param matchId It required valid match id to be passed.
     * @return all details about played match
     * @throws IllegalArgumentException if match not has been played yet
     */
    @GetMapping("/{match_id}/")
    public ResponseEntity<Match> getScoreCard(@PathVariable(value = "match_id") Long matchId){
        return ResponseEntity.ok(matchService.getScoreCard(matchId));
    }

}
