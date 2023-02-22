package com.cricketGame.models;

import com.cricketGame.constants.Constants;
import com.cricketGame.models.enums.MatchFormat;
import com.cricketGame.models.innings.Innings;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "match_of_cricket")
@NoArgsConstructor
public class Match extends Bean{
    @OneToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "team1_id", referencedColumnName = "id")
    private Team team1;
    @OneToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "team2_id", referencedColumnName = "id")
    private Team team2;
    @Enumerated(EnumType.STRING)
    private MatchFormat format;
    @OneToMany(targetEntity = Innings.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private List<Innings> innings;
    @OneToOne(targetEntity = Team.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private Team winner;
    public Match(long matchId, Team team1, Team team2, int allowedTeamSize, String format){
        super(matchId);
        this.team1 = team1;
        this.team2 = team2;
        Constants.ALLOWED_TEAM_SIZE = allowedTeamSize;
        this.innings = new ArrayList<>();
        this.format = MatchFormat.getMatchFormat(format);
        Constants.MAX_NO_OF_OVERS = this.format.getNoOfOvers();
    }

    public void swap(){
        Team temp = this.team1;
        this.team1 = this.team2;
        this.team2 = temp;
    }

    public Innings addNewInnings(Innings inning){
        this.innings.add(inning);
        return inning;
    }
}
