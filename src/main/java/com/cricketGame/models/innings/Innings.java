package com.cricketGame.models.innings;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.Bean;
import com.cricketGame.models.Team;
import com.cricketGame.models.player.Player;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Innings extends Bean {
    @ManyToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name="batting_team_id", referencedColumnName = "id")
    private final Team battingTeam;
    @ManyToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name="bowling_team_id", referencedColumnName = "id")
    private final Team bowlingTeam;
    @Transient
    private List<Over> overs = new ArrayList<>();
    @Transient
    private List<Wicket> wickets = new ArrayList<>();
    public Innings(Team battingTeam, Team bowlingTeam){
        super(ObjectIDGenerator.getID());
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        for(int i = 0; i<Constants.OVERS_FOR_T20; i++)
            this.overs.add(new Over());
    }
}
