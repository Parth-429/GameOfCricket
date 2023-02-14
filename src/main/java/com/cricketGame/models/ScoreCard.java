package com.cricketGame.models;

import com.cricketGame.constants.Constants;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ScoreCard {
    private List<Over> overs;
    private List<Wicket> wickets;
    public ScoreCard(){
        this.overs = new ArrayList<>();
        for(int i = 0; i < Constants.OVERS_FOR_T20; i++) {
            this.overs.add(new Over(i));
        }
        this.wickets = new ArrayList<>();
    }
}
