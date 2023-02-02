package com.CricketGame.Entities;

public class Match {
    private final Integer Match_id;
    private Team team1, team2;
    private Team Winner;
    private Player ManOfTheMatch;
    private final Integer Overs;
    private final ScoreCard scoreCard1, scoreCard2;

    public Match(Integer match_id, Team team1, Team team2, Integer Overs, ScoreCard scoreCard1, ScoreCard scoreCard2) {
        Match_id = match_id;
        this.team1 = team1;
        this.team2 = team2;
        this.Overs = Overs;
        this.scoreCard1 = scoreCard1;
        this.scoreCard2 = scoreCard2;
    }

    public void setWinner(Team winner) {
        Winner = winner;
    }

    public void setManOfTheMatch(Player manOfTheMatch) {
        ManOfTheMatch = manOfTheMatch;
    }

    public Integer getMatch_id() {
        return Match_id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void swap(){
        Team temp = this.team1;
        this.team1 = this.team2;
        this.team2 = temp;
    }

    public Team getTeam2() {
        return team2;
    }

    public Team getWinner() {
        return Winner;
    }

    public Player getManOfTheMatch() {
        return ManOfTheMatch;
    }

    public Integer getOvers(){
        return this.Overs;
    }

    public ScoreCard getFirstInningScoreCard(){
        return this.scoreCard1;
    }
    public ScoreCard getSecondInninfScoreCard(){
        return this.scoreCard2;
    }

    @Override
    public String toString() {
        return (String.format("Match Summary:\n\n FirstInning:\n") + getTeam1() + String.format("\nSecondInning:\n") + getTeam2() + "Winner is : " + Winner.getName() + "\n");
    }
}
