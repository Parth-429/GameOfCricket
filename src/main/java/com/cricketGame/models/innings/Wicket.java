package com.cricketGame.models.innings;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.Bean;
import com.cricketGame.models.enums.WicketType;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Wicket extends Bean {
    private long playerID;
    @Enumerated(EnumType.STRING)
    private WicketType wicketType;
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
