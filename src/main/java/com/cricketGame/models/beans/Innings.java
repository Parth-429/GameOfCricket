package com.cricketGame.models.beans;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.beans.team.TeamHistory;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@NoArgsConstructor
public class Innings extends Bean {
    @ManyToOne(targetEntity = TeamHistory.class, cascade = CascadeType.ALL)
    @JoinColumn(name="batting_team_id", referencedColumnName = "id")
    private TeamHistory battingTeam;
    @ManyToOne(targetEntity = TeamHistory.class, cascade = CascadeType.ALL)
    @JoinColumn(name="bowling_team_id", referencedColumnName = "id")
    private TeamHistory bowlingTeam;
    @OneToMany(targetEntity = Over.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "inning_id", referencedColumnName = "id")
    private List<Over> overs = new ArrayList<>();
    @OneToMany( targetEntity = Wicket.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "inning_id", referencedColumnName = "id")
    private List<Wicket> wickets = new ArrayList<>();
    public Innings(TeamHistory battingTeam, TeamHistory bowlingTeam){
        super(ObjectIDGenerator.getID());
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        for(int i = 0; i<Constants.MAX_NO_OF_OVERS; i++)
            this.overs.add(new Over());
    }
}
