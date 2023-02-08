package com.cricketGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Player {
    private String name;
    private String role;
    private boolean isOut = false;
    public abstract void updateBattingStatistics(int run);
}
