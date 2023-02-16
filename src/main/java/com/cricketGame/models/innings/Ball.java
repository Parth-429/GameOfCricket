package com.cricketGame.models.innings;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.Bean;
import com.cricketGame.models.enums.Runs;
import com.cricketGame.models.player.Player;
import com.cricketGame.models.stats.BatsmanStats;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "ball")
public class Ball extends Bean {
    @ManyToOne(targetEntity = Player.class, cascade = CascadeType.ALL)
    @JoinColumn(name="bowler_id", referencedColumnName = "id")
    private final Player bowler;
    @Transient
    private PartnerShip batsmanPartnerShip;
    @Enumerated(EnumType.STRING)
    private final Runs runMade;
    private int ball_no;
    @Transient
    private Optional<Wicket> checkWicket;
    public Ball(long ballID, Player bowler, PartnerShip batsmanPartnerShip, Runs run){
        super(ballID);
        this.batsmanPartnerShip = batsmanPartnerShip;
        this.bowler = bowler;
        this.runMade = run;
        this.ball_no = ++Constants.CURRENT_BALL_NO;
    }
    public void setWicket(Wicket wicket){
        this.checkWicket = Optional.of(wicket);
        ((BatsmanStats)(this.batsmanPartnerShip.getStriker().getBatsmanStats())).setWicketStats(Optional.of(this));
    }
}
