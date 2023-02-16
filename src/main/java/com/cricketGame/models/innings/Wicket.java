package com.cricketGame.models.innings;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.Bean;
import com.cricketGame.models.enums.WicketType;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Wicket extends Bean {
    private final long playerID;
    @Enumerated(EnumType.STRING)
    private final WicketType wicketType;
    @OneToOne(targetEntity = Ball.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "wicket_ball_id", referencedColumnName = "id")
    private Ball onWhichBall;
    private int wicketNo;
    public Wicket(long playerId, WicketType wicketType){
        super(ObjectIDGenerator.getID());
        this.playerID = playerId;
        this.wicketType = wicketType;
        this.wicketNo = ++Constants.CURRENT_WICKET_NO;
    }
}
