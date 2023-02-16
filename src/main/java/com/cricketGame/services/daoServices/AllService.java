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
    public static BatsmanStatsService batsmanStatsService;
    public static BowlingStatsService bowlingStatsService;
    public static MatchService matchService;
    public static InningsService inningsService;
    public static PlayerService playerService;
    public static TeamService teamService;
    public static OverService overService;
    public static  BallService ballService;
    public static  WicketService wicketService;
    public static  PartnerShipService partnerShipService;
    public static TeamStatsService teamStatsService;
    @Autowired
    public AllService(BatsmanStatsService batsmanStatsService, BowlingStatsService bowlingStatsService,
                      MatchService matchService, InningsService inningsService, PlayerService playerService,
                      TeamService teamService, PartnerShipService partnerShipService, WicketService wicketService,
                      OverService overService, BallService ballService, TeamStatsService teamStatsService) {
        this.bowlingStatsService = bowlingStatsService;
        this.batsmanStatsService = batsmanStatsService;
        this.teamService = teamService;
        this.playerService = playerService;
        this.matchService = matchService;
        this.inningsService = inningsService;
        this.overService = overService;
        this.wicketService = wicketService;
        this.partnerShipService = partnerShipService;
        this.ballService = ballService;
        this.teamStatsService = teamStatsService;
    }

    public static void runAllServices(Match match){
        for(Innings innings:match.getInnings()){
            inningsService.saveOversAndWickets(innings);
        }
        teamService.savePlayerStats(match.getTeam1());
        teamService.savePlayerStats(match.getTeam2());
        teamStatsService.saveTeamStats((TeamStats) match.getTeam1().getTeamStats());
        teamStatsService.saveTeamStats((TeamStats) match.getTeam2().getTeamStats());
    }
}
