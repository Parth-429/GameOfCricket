package com.CricketGame.Entities;

import ch.qos.logback.core.joran.sanity.Pair;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamHistory {
    private Integer TotalRuns = 0;
    private Integer TotalWickets = 0;
    private Boolean isWin = false;

    private Integer balls = 0;

    public Integer getBalls() {
        return balls;
    }

    public void addBalls() {
        this.balls++;
    }

    private final Integer TotalNoPlayers;
    private final List<Player> PlayerList;
    public TeamHistory(Integer noPlayers, List<Player> Players){
        this.TotalNoPlayers = noPlayers;
        this.PlayerList = Players;
    }

    public Integer getTotalRuns() {
        return TotalRuns;
    }

    public void AddTotalRuns(Integer totalRuns) {
        this.TotalRuns += totalRuns;
    }

    public Integer getTotalWickets() {
        return TotalWickets;
    }

    public void IncrementWickets() {
        TotalWickets++;
    }

    public Boolean getWin() {
        return isWin;
    }

    public void setWin(Boolean win) {
        isWin = win;
    }

    public Integer getTotalNoPlayers() {
        return TotalNoPlayers;
    }
    public List<Player> getPlayerList() {
        return PlayerList;
    }

    @Override
    public String toString() {
        return String.format("\t %d / %d, Overs: %.2f\n", TotalRuns, TotalWickets, (balls/6.0));
    }
}
