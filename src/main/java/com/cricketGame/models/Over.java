package com.cricketGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Over {
    private int overNo;
    private List<Ball> ballsOfOver = new ArrayList<>();
    public Over(int overNo){
        this.overNo = overNo;
        this.ballsOfOver = new ArrayList<>();
    }
    public int getTotalRunScoredInOver(){
        int totalRunScoredInOver = 0;
        for(Ball ball: ballsOfOver){
            totalRunScoredInOver += ball.getRunMade().getRun();
        }
        return totalRunScoredInOver;
    }
}
