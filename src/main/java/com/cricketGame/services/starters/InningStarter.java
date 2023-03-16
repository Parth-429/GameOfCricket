package com.cricketGame.services.starters;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.beans.*;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.models.enums.Role;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.enums.WicketType;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.generators.ObjectIDGenerator;
import com.cricketGame.services.generators.RandomNumberGenerator;
import com.cricketGame.services.generators.RunGenerator;
import com.cricketGame.services.playerSelector.BatsmanSelector;
import com.cricketGame.services.playerSelector.BowlerSelector;
import lombok.Data;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@UtilityClass
public class InningStarter {
    public int playInning(TeamHistory battingTeam, TeamHistory bowlingTeam, Innings inning, Boolean isSecondInning) {

        boolean isAllOut = false;
        List<Player> battingTeamBatsman = new ArrayList<>(battingTeam.getPlayers());
        List<Player> bowlingTeamBowlers = new ArrayList<>();
        for (Player player : bowlingTeam.getPlayers()) {
            if (Role.BOWLER.equals(player.getRole())) {
                bowlingTeamBowlers.add(player);
            }
        }

        PartnerShip partnerShipOfStrikerNonStriker = new PartnerShip(BatsmanSelector.selectBatsman(battingTeamBatsman),
                BatsmanSelector.selectBatsman(battingTeamBatsman));
        int target = Integer.MAX_VALUE;
        if (isSecondInning) {
            target = ((TeamStats) (bowlingTeam.getTeamStats())).getTotalScore();
        }
        Player bowler = null;

        for (Over over : inning.getOvers()) {
            bowler = BowlerSelector.selectBowler(bowler, bowlingTeamBowlers);
            for (int ball = Constants.BALL_START; ball <= Constants.MAX_BALLS_IN_ONE_OVER; ball++) {

                Runs runOnThisBall = getRuns(partnerShipOfStrikerNonStriker);
                addBalltoOver(partnerShipOfStrikerNonStriker, bowler, over, runOnThisBall);
                if (runOnThisBall.equals(Runs.WICKET)) {
                    updateStatisticsAfterWicket(inning, battingTeamBatsman, partnerShipOfStrikerNonStriker, over, ball, runOnThisBall);
                    partnerShipOfStrikerNonStriker = new PartnerShip(BatsmanSelector.selectBatsman(battingTeamBatsman),
                            partnerShipOfStrikerNonStriker.getNonStriker());
                    isAllOut = checkIsAllOut(false, partnerShipOfStrikerNonStriker);
                } else {
                    updateStatisticsIfNotWicket(partnerShipOfStrikerNonStriker, runOnThisBall);
                }

                battingTeam.getTeamStats().updateStats(runOnThisBall);
                bowler.getBowlerStats().updateStats(runOnThisBall);
                if (isAllOut || ((TeamStats) battingTeam.getTeamStats()).getTotalScore() > target) {
                    ((TeamStats) battingTeam.getTeamStats()).setOvers(
                            over.getOverNo() + ((ball == Constants.MAX_BALLS_IN_ONE_OVER) ? 1 : 0) + "." +
                            ball % Constants.MAX_BALLS_IN_ONE_OVER);
                    Constants.resetWicketNo();
                    Constants.resetCurrentOverNo();
                    Constants.resetBallNo();
                    return ((TeamStats) battingTeam.getTeamStats()).getTotalScore();
                }
            }
            partnerShipOfStrikerNonStriker.swap();
            Constants.resetBallNo();
        }
        ((TeamStats) battingTeam.getTeamStats()).setOvers( Constants.OVERS_FOR_T20 + ".0");
        Constants.resetWicketNo();
        Constants.resetCurrentOverNo();
        return ((TeamStats) battingTeam.getTeamStats()).getTotalScore();
    }

    private void updateStatisticsIfNotWicket(PartnerShip partnerShipOfStrikerNonStriker, Runs runOnThisBall) {
        int currentRun = runOnThisBall.getRun();
        getStriker(partnerShipOfStrikerNonStriker).getBatsmanStats().updateStats(runOnThisBall);
        partnerShipOfStrikerNonStriker.updateRunsMadeInPartnerShip(runOnThisBall);
        if (currentRun % 2 == 1) {
            partnerShipOfStrikerNonStriker.swap();
        }
    }

    private void updateStatisticsAfterWicket(Innings scorecard, List<Player> battingTeamBatsman,
                                             PartnerShip partnerShipOfStrikerNonStriker,
                                                    Over over, int ball, Runs runOnThisBall) {
        getStriker(partnerShipOfStrikerNonStriker).getBatsmanStats().updateStats(runOnThisBall);
        Wicket wicket = new Wicket(getStriker(partnerShipOfStrikerNonStriker).getId(), getWicketType());
        over.getBallsOfOver().get(ball - 1).setWicket(wicket);
        scorecard.getWickets().add(wicket);
    }

    private boolean checkIsAllOut(boolean isAllOut, PartnerShip partnerShipOfStrikerNonStriker) {
        if (Objects.isNull(getStriker(partnerShipOfStrikerNonStriker))) {
            isAllOut = true;
            partnerShipOfStrikerNonStriker.swap();
        }
        return isAllOut;
    }

    private void addBalltoOver(PartnerShip partnerShipOfStrikerNonStriker, Player bowler, Over over, Runs runOnThisBall) {
        over.getBallsOfOver()
            .add(new Ball(ObjectIDGenerator.getID(), bowler, partnerShipOfStrikerNonStriker, runOnThisBall));
    }

    private Runs getRuns(PartnerShip partnerShipOfStrikerNonStriker) {
        Runs runOnThisBall;
        if (Role.BATSMAN.equals(getStriker(partnerShipOfStrikerNonStriker).getRole())) {
            runOnThisBall = RunGenerator.generateRun(Role.BATSMAN);
        } else {
            runOnThisBall = RunGenerator.generateRun(Role.BOWLER);
        }
        return runOnThisBall;
    }

    private Player getStriker(PartnerShip partnerShipOfStrikerNonStriker) {
        return partnerShipOfStrikerNonStriker.getStriker();
    }

    private WicketType getWicketType() {
        return WicketType.values()[RandomNumberGenerator.getInstance().nextInt(WicketType.values().length)];
    }
}
