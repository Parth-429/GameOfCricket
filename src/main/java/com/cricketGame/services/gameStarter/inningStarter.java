package com.cricketGame.services.gameStarter;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.*;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.enums.WicketType;
import com.cricketGame.models.innings.Ball;
import com.cricketGame.models.innings.Over;
import com.cricketGame.models.innings.Pair;
import com.cricketGame.models.innings.Wicket;
import com.cricketGame.models.player.Player;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.generators.ObjectIDGenerator;
import com.cricketGame.services.generators.RandomNumberGenerator;
import com.cricketGame.services.generators.RunGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.cricketGame.services.playerSelector.SelectBatsman.selectBatsman;
import static com.cricketGame.services.playerSelector.SelectBowler.selectBowler;

public class inningStarter {

    public static int playInning(Team battingTeam, Team bowlingTeam, ScoreCard scorecard, Boolean isSecondInning) {

        boolean isAllOut = false;
        List<Player> battingTeamBatsman = new ArrayList<>(battingTeam.getPlayers());
        List<Player> bowlingTeamBowlers = new ArrayList<>();
        for (Player player : bowlingTeam.getPlayers()) {
            if (Role.BOWLER.equals(player.getRole())) {
                bowlingTeamBowlers.add(player);
            }
        }

        Pair pairOfStrikerNonStriker = new Pair(selectBatsman(battingTeamBatsman), selectBatsman(battingTeamBatsman));
        int target = Integer.MAX_VALUE;
        if (isSecondInning) {
            target = ((TeamStats) (bowlingTeam.getTeamStats())).getTotalScore();
        }
        Player bowler = null;
        int overNo = 0;

        for (Over over : scorecard.getOvers()) {
            bowler = selectBowler(bowler, bowlingTeamBowlers);
            for (int ball = Constants.BALL_START; ball <= Constants.MAX_BALLS_IN_ONE_OVER; ball++) {

                Runs runOnThisBall = getRuns(pairOfStrikerNonStriker);
                addBalltoOver(pairOfStrikerNonStriker, bowler, over, runOnThisBall);
                if (runOnThisBall.equals(Runs.WICKET)) {
                    updateStatisticsAfterWicket(scorecard, battingTeamBatsman, pairOfStrikerNonStriker, over, ball, runOnThisBall);
                    isAllOut = checkIsAllOut(isAllOut, pairOfStrikerNonStriker);
                } else {
                    updateStatisticsIfNotWicket(pairOfStrikerNonStriker, runOnThisBall);
                }

                battingTeam.getTeamStats().updateStats(runOnThisBall);
                bowler.getBowlerStats().updateStats(runOnThisBall);
                if (isAllOut || ((TeamStats) battingTeam.getTeamStats()).getTotalScore() > target) {
                    ((TeamStats) battingTeam.getTeamStats()).setOvers(
                            over.getOverNo() + ((ball == Constants.MAX_BALLS_IN_ONE_OVER) ? 1 : 0) + "." +
                            ball % Constants.MAX_BALLS_IN_ONE_OVER);
                    Wicket.resetWicketNo();
                    return ((TeamStats) battingTeam.getTeamStats()).getTotalScore();
                }
            }
            overNo++;
            pairOfStrikerNonStriker.swap();
        }

        ((TeamStats) battingTeam.getTeamStats()).setOvers(overNo + ".0");
        Wicket.resetWicketNo();
        return ((TeamStats) battingTeam.getTeamStats()).getTotalScore();
    }

    private static void updateStatisticsIfNotWicket(Pair pairOfStrikerNonStriker, Runs runOnThisBall) {
        int currentRun = runOnThisBall.getRun();
        getStriker(pairOfStrikerNonStriker).getBatsmanStats().updateStats(runOnThisBall);
        if (currentRun % 2 == 1) {
            pairOfStrikerNonStriker.swap();
        }
    }

    private static void updateStatisticsAfterWicket(ScoreCard scorecard, List<Player> battingTeamBatsman, Pair pairOfStrikerNonStriker,
                                  Over over, int ball, Runs runOnThisBall) {
        getStriker(pairOfStrikerNonStriker).getBatsmanStats().updateStats(runOnThisBall);
        Wicket wicket = new Wicket(getStriker(pairOfStrikerNonStriker).getId(), getWicketType());
        over.getBallsOfOver().get(ball - 1).setWicket(wicket);
        scorecard.getWickets().add(wicket);
        pairOfStrikerNonStriker.setStriker(selectBatsman(battingTeamBatsman));
    }

    private static boolean checkIsAllOut(boolean isAllOut, Pair pairOfStrikerNonStriker) {
        if (Objects.isNull(getStriker(pairOfStrikerNonStriker))) {
            isAllOut = true;
            pairOfStrikerNonStriker.swap();
        }
        return isAllOut;
    }

    private static void addBalltoOver(Pair pairOfStrikerNonStriker, Player bowler, Over over, Runs runOnThisBall) {
        over.getBallsOfOver()
            .add(new Ball(ObjectIDGenerator.getID(), bowler, pairOfStrikerNonStriker, runOnThisBall));
    }

    private static Runs getRuns(Pair pairOfStrikerNonStriker) {
        Runs runOnThisBall;
        if (Role.BATSMAN.equals(getStriker(pairOfStrikerNonStriker).getRole())) {
            runOnThisBall = RunGenerator.generateRun(Role.BATSMAN);
        } else {
            runOnThisBall = RunGenerator.generateRun(Role.BOWLER);
        }
        return runOnThisBall;
    }

    private static Player getStriker(Pair pairOfStrikerNonStriker) {
        return pairOfStrikerNonStriker.getStriker();
    }

    private static WicketType getWicketType() {
        return WicketType.values()[RandomNumberGenerator.getInstance().nextInt(WicketType.values().length)];
    }
}
