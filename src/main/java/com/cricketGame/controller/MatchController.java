package com.cricketGame.controller;


import com.cricketGame.dto.MatchDTO;
import com.cricketGame.mappers.MatchMapper;
import com.cricketGame.models.beans.Match;
import com.cricketGame.services.daoServicesImpl.MatchService;
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

    /**
     * Create match object and save all info about match into database.
     * @param matchDTO  Have the all info required to create match. It contains info about two teams, allowed
     *                  team-size in match and format of the match. For each team it need to pass info about players,
     *                  team-size and for each player, you need to pass its role and batting order.
     *
     *                  Please ensure matchDto has correct information:
     *                  Format should be T20, ODI or TEST.
     *                  TeamDto contains team id, and team should exist before you play match between them. If not,
     *                  that go to  create team first using team api
     *                  Both team should be different in one match
     *                  Team-size, number of players in each team and your allowed team size for match should be same
     *                  Each team should ensure that the batting order of each player is unique, and also it fulfills
     *                  minimum number of bowler's requirement
     *                  Each player contains his person id, and person should exist before you put it into any team
     *                  as player, if not then please create person first using person api
     *                  All players in one match should contain unique, person id. and all should valid.
     *
     *                  It will create player object for person, and team history object for team, which will store
     *                  history of person as player and team as team history in match.
     *                  It will create inning array to store information about all innings in match. and according to
     *                  format fix the number of over for match
     *
     * @return matchDTO  it returns same object that you passed
     *
     */
    @PostMapping("/")
    public ResponseEntity<MatchDTO> addMatch(@Valid @RequestBody MatchDTO matchDTO){
        Match match = matchService.saveMatch(matchDTO);
        return ResponseEntity.ok(matchMapper.toMatchDto(match));
    }

    /**
     * Start the match and return fully-detailed scorecard
     * @param id It required valid match id to be passed. And it first checks the current status of match, is it
     *           played before, running or new match.
     * @return fully-detailed scorecard contains info about, toss, batting and bowling summary of each team and
     * @throws IllegalArgumentException if match not exist or if it is already been played.
     */
    @PostMapping("/start/{id}/")
    public String startMatch(@PathVariable Long id){
       return matchService.checkMatchIsPlayedOrNot(id);
    }

    /**
     * It returns all matched played by any team
     * @param teamId it requires valid team id
     * @return list of match info played by team
     * @throws IllegalArgumentException if team not exist
     */
    @GetMapping("/playedMatches/{team_id}/")
    public ResponseEntity<List<MatchDTO>> findMatchesPlayedByTeam(@PathVariable Long teamId){
        return ResponseEntity.ok(matchService.findMatchPlayedByTeamById(teamId));
    }

    /**
     *  It retursn scorecard of match
     * @param matchId It required valid match id to be passed.
     * @return all details about played match
     * @throws IllegalArgumentException if match not has been played yet
     */
    @GetMapping("/scoreCard/{match_id}/")
    public ResponseEntity<Match> getScoreCard(@PathVariable(value = "match_id") Long matchId){
        return ResponseEntity.ok(matchService.getScoreCard(matchId));
    }

}
