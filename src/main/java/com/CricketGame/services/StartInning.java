package com.cricketGame.services;

import com.cricketGame.models.*;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.stats.TeamStats;

import java.util.ArrayList;
import java.util.List;

import static com.cricketGame.services.playerSelector.SelectBatsman.selectBatsman;
import static com.cricketGame.services.playerSelector.SelectBowler.selectBowler;

public class StartInning {
    public static int playInning(Team battingTeam, Team bowlingTeam, ScoreCard scorecard, Boolean isSecondInning){

        final int MAX_ALLOWED_BALLS = 6;
        boolean isAllOut = false;

        List<Player> battingTeamBatsman = new ArrayList<>(battingTeam.getPlayers());
        List<Player> bowlingTeamBowlers = new ArrayList<>();
        for(Player player: bowlingTeam.getPlayers()){
            if(player.getRole().equals("Bowler"))
                bowlingTeamBowlers.add(player);
        }

        Pair pairOfStrikerNonStriker = new Pair(selectBatsman(battingTeamBatsman), selectBatsman(battingTeamBatsman));
        int target = Integer.MAX_VALUE;
        if(isSecondInning) target = ((TeamStats)(bowlingTeam.getTeamStats())).getTotalScore();
        Player bowler = null;
        int overNo = 0;

        for(Over over: scorecard.getOvers()){
            bowler = selectBowler(bowler, bowlingTeamBowlers);
            for(int ball=1; ball<=MAX_ALLOWED_BALLS; ball++) {
                Runs runOnThisBall = RunGenerator.generateRun();
                over.getBallsOfOver().add(new Ball(ObjectIDGenerator.getID(), bowler, pairOfStrikerNonStriker, runOnThisBall));
                if (runOnThisBall.equals(Runs.WICKET)) {
                    pairOfStrikerNonStriker.getStriker().getBatsmanStats().updateStats(runOnThisBall);
                    Wicket wicket = new Wicket(pairOfStrikerNonStriker.getStriker().getPersonID(),"Bowled By");
                    over.getBallsOfOver().get(ball-1).setWicket(wicket);
                    scorecard.getWickets().add(wicket);
                    pairOfStrikerNonStriker.setStriker(selectBatsman(battingTeamBatsman));
                    if ( pairOfStrikerNonStriker.getStriker() == null) {
                        isAllOut = true;
                        pairOfStrikerNonStriker.swap();
                    }
                } else {
                    int currentRun = runOnThisBall.getRun();
                    pairOfStrikerNonStriker.getStriker().getBatsmanStats().updateStats(runOnThisBall);
                    if (currentRun % 2 == 1)
                        pairOfStrikerNonStriker.swap();
                }
                battingTeam.getTeamStats().updateStats(runOnThisBall);
                bowler.getBowlerStats().updateStats(runOnThisBall);
                if (isAllOut || ((TeamStats)battingTeam.getTeamStats()).getTotalScore() > target) {
                    ((TeamStats)battingTeam.getTeamStats()).setOvers(over.getOverNo() + ((ball == 6) ? 1 : 0) + "." + Integer.toString(ball%6));
                    Wicket.resetWicketNo();
                    return ((TeamStats)battingTeam.getTeamStats()).getTotalScore();
                }
            }
            overNo++;
            pairOfStrikerNonStriker.swap();
        }
        ((TeamStats)battingTeam.getTeamStats()).setOvers(overNo +".0");
        Wicket.resetWicketNo();
        return ((TeamStats)battingTeam.getTeamStats()).getTotalScore();
    }
}
