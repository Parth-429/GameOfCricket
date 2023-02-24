package com.cricketGame.models.enums;

import lombok.Getter;

@Getter
public enum Role {
    BOWLER("Bowler"),
    BATSMAN("Batsman");
    private final String displayValue;
    Role(String role){
        this.displayValue = role;
    }
    public static Role getRole(String role){
       return Role.valueOf(role);
    }
}
