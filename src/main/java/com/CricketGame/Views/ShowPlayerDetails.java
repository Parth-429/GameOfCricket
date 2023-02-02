
package com.CricketGame.Views;
import com.CricketGame.Entities.Player;

class ShowPlayerDetails{

    private Player player;

    public ShowPlayerDetails(Player player){
        this.player = player;
        System.out.println(this);
    }
    public void ShowBattingSummary(){
        System.out.println(this.player.getBatsman());
    }

    public void ShowBowlingSummary(){
        System.out.println(this.player.getBowler());
    }

    public void ShowOverAllSummary(){
        this.ShowBattingSummary();
        this.ShowBowlingSummary();
    }
}
