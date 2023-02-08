package com.cricketGame.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ScoreCard {
    private List<Over> overs;
    private List<Wicket> wickets;
    public ScoreCard(int overs){
        this.overs = new ArrayList<>();
        for(int i=0; i<overs; i++)
            this.overs.add(new Over(i));
        this.wickets = new ArrayList<>();
    }
}
