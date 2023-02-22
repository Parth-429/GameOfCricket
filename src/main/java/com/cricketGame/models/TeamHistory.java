package com.cricketGame.models;
import com.cricketGame.models.player.Player;
import com.cricketGame.models.stats.Stats;
import com.cricketGame.models.stats.TeamStats;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class TeamHistory extends Bean{
    @ManyToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team _team;
    @OneToOne(targetEntity = TeamStats.class, mappedBy = "team", cascade = CascadeType.ALL)
    private Stats teamStats;
    private int teamSize;
    @OneToMany(targetEntity = Player.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private List<Player> players;
    public TeamHistory(Long teamId, Team _team, List<Player> players, int teamSize){
        super(teamId);
        this._team = _team;
        try{
            if(teamSize!=players.size())
                throw new IllegalArgumentException("Team Size and Number of Players in List Should be Same");
            this.teamSize = teamSize;
        }
        catch(Exception e){
            System.out.println("Data Validation Error : " + e.getMessage());
            e.printStackTrace();
        }
        this.players = players;
    }
    public Stats getTeamStats() {
        if(Objects.isNull(this.teamStats)) {
            this.teamStats = new TeamStats();
            ((TeamStats) (this.teamStats)).setId(ObjectIDGenerator.getID());
            ((TeamStats) (this.teamStats)).setTeam(this);
        }
        return teamStats;
    }

    public String getName() {
        return this._team.getName();
    }
}
