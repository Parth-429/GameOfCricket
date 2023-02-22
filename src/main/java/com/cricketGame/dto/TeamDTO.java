package com.cricketGame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Long teamId;
    private int teamSize;
    private List<PlayerDTO> players;
}
