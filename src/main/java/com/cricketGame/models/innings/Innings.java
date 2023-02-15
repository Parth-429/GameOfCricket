package com.cricketGame.models.innings;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.Bean;
import com.cricketGame.models.Team;
import com.cricketGame.services.generators.ObjectIDGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class Innings extends Bean {
    @Transient
    private final Team battingTeam;
    @Transient
    private final Team bowlingTeam;
    @Transient
    private List<Over> overs;
    @Transient
    private List<Wicket> wickets = new ArrayList<>();
    public Innings(Team battingTeam, Team bowlingTeam){
        super(ObjectIDGenerator.getID());
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.overs = Collections.nCopies(Constants.OVERS_FOR_T20,new Over());
    }
}
