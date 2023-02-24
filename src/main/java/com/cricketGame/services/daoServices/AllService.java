package com.cricketGame.services.daoServices;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//name change daoService
@Component
@Data
public class AllService {
    public static MatchService matchService;
    public static PlayerService playerService;
    public static TeamHistoryService teamHistoryService;
    public static PersonService personService;
    public static TeamService teamService;
    @Autowired
    public AllService(MatchService matchService, PlayerService playerService,
                      TeamHistoryService teamHistoryService, PersonService personService, TeamService teamService) {
        AllService.teamHistoryService = teamHistoryService;
        AllService.playerService = playerService;
        AllService.matchService = matchService;
        AllService.teamService = teamService;
        AllService.personService = personService;
    }
}
