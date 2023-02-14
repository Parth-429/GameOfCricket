package com.cricketGame.models;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.innings.Over;
import com.cricketGame.models.innings.Wicket;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ScoreCard {
    private List<Over> overs = new ArrayList<>();
    private List<Wicket> wickets = new ArrayList<>();;
    public ScoreCard(){
        for(int i = 0; i < Constants.OVERS_FOR_T20; i++) {
            this.overs.add(new Over(i));
        }
    }
}
