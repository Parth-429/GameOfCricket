package com.cricketGame.models;
import com.cricketGame.constants.Constants;
import com.cricketGame.models.player.Player;
import com.cricketGame.models.stats.Stats;
import com.cricketGame.models.stats.TeamStats;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
public class Team extends Bean{
    private final String name;
    private Stats teamStats;
    private int teamSize;
    private List<Player> players;
    public Team(long teamId, String name, List<Player> players, int teamSize){
        super(teamId);
        this.name = name;
        try{
            if(teamSize!=players.size())
                throw new IllegalArgumentException("Team Size and Number of Players in List Should be Same");
            if(teamSize != Constants.ALLOWED_TEAM_SIZE)
                throw new IllegalArgumentException("Team Size should be match to no. of players allowed in match");
            this.teamSize = teamSize;
        }
        catch(Exception e){
            System.out.println("Data Validation Error : " + e.getMessage());
            e.printStackTrace();
        }
        this.players = players;
        this.teamStats = new TeamStats();
    }
}
