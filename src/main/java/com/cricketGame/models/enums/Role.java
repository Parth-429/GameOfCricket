package com.cricketGame.models.enums;

import com.cricketGame.constants.Constants;

public enum Role {
    Bowler("Bowler"),
    Batsman("Batsman");
    private String role;
    Role(String role){
        this.role = role;
    }
    public static Role getRole(String role){
        if(Constants.BATTING_ROLE.equals(role))
            return Role.Batsman;
        else if(Constants.BOWLING_ROLE.equals(role))
            return Role.Bowler;
        else return null;
    }
}
