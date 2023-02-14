package com.cricketGame.models.enums;

import com.cricketGame.constants.Constants;
import lombok.Data;
import lombok.Getter;

@Getter
public enum Role {
    BOWLER("Bowler"),
    BATSMAN("Batsman");
    private String roleOfPlayer;
    Role(String role){
        this.roleOfPlayer = role;
    }
    public static Role getRole(String role){
        if(Constants.BATTING_ROLE.equals(role))
            return Role.BATSMAN;
        else if(Constants.BOWLING_ROLE.equals(role))
            return Role.BOWLER;
        else return null;
    }
}
