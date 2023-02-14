package com.cricketGame.models.innings;

import com.cricketGame.models.Bean;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.player.Player;
import com.cricketGame.models.stats.BatsmanStats;
import lombok.Data;

import java.util.Optional;

@Data
public class Ball extends Bean {
    private final Player bowler;
    private Pair batsmanPair;
    private final Runs runMade;
    private Optional<Wicket> checkWicket;
    public Ball(long ballID, Player bowler, Pair batsmanPair, Runs run){
        this.setId(ballID);
        this.batsmanPair = batsmanPair;
        this.bowler = bowler;
        this.runMade = run;
    }
    public void setWicket(Wicket wicket){
        this.checkWicket = Optional.of(wicket);
        ((BatsmanStats)(this.batsmanPair.getStriker().getBatsmanStats())).setWicketStats(Optional.of(this));
    }
}
