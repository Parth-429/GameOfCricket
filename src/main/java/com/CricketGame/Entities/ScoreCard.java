package com.CricketGame.Entities;

import java.util.ArrayList;
import java.util.List;


public class ScoreCard {
    private List<Over> OverWiseHistory;
    public ScoreCard(Integer overs) {
        OverWiseHistory = new ArrayList<>(overs);
        for(int i=0; i<overs; i++)
            this.OverWiseHistory.set(i,new Over());
    }
    public List<Over> getScoreCard(){
        return OverWiseHistory;
    }
}
