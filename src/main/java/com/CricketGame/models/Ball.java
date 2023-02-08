package com.cricketGame.models;

import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.stats.BatsmanStats;
import com.cricketGame.models.stats.BowlerStats;
import lombok.Data;

import java.util.Optional;

@Data
public class Ball {
    private final long ballID;
    private final Player bowler;
    private Pair batsmanPair;
    private final Runs runMade;
    private Optional<Wicket> checkWicket;
    public Ball(long ballID, Player bowler, Pair batsmanPair, Runs run){
        this.ballID = ballID;
        this.batsmanPair = batsmanPair;
        this.bowler = bowler;
        this.runMade = run;
    }
    public void setWicket(Wicket wicket){
        this.checkWicket = Optional.of(wicket);
        ((BatsmanStats)(this.batsmanPair.getStriker().getBatsmanStats())).setWicketStats(Optional.of(this));
    }
}
