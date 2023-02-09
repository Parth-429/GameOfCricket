package com.cricketGame.models;
import com.cricketGame.models.stats.Stats;
import com.cricketGame.models.stats.TeamStats;
import lombok.Data;

import java.util.List;

@Data
public class Team {
    private long teamId;
    private String name;
    private Stats teamStats;
    private final int teamSize;
    private List<Player> players;
    public Team(long teamId, String name, List<Player> players){
        this.teamId = teamId;
        this.name = name;
        this.teamSize = players.size();
        this.players = players;

        this.teamStats = new TeamStats();
    }
}
