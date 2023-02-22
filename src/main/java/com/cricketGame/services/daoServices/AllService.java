package com.cricketGame.services.daoServices;

import com.cricketGame.models.Match;
import com.cricketGame.models.innings.Innings;
import com.cricketGame.models.stats.TeamStats;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class AllService {
    public static MatchService matchService;
    public static PlayerService playerService;
    public static TeamService teamService;

    public static PersonService personService;
    public static _TeamService _teamService;
    @Autowired
    public AllService(MatchService matchService,PlayerService playerService,
                      TeamService teamService, PersonService personService, _TeamService _teamService) {
        this.teamService = teamService;
        this.playerService = playerService;
        this.matchService = matchService;
        this._teamService = _teamService;
        this.personService = personService;
    }
}
