package com.CricketGame.Services;
import com.CricketGame.Entities.Player;
public class UpdatePlayerDetails {
    private Player player;
    public UpdatePlayerDetails(Player player) {
        this.player = player;
    }

    public void updateBatsmanDetails(int run, int ball,int six, int four) {
        UpdateBatsman obj = new UpdateBatsman(this.player);
        obj.update(run,ball,six,four);
    }

    public void updateBowlerDetails(int wickets){
        UpdateBowler obj = new UpdateBowler(this.player);
        obj.update(wickets);
    }
}


