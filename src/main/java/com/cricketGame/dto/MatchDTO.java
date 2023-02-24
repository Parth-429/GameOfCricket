package com.cricketGame.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchDTO {
    private TeamDTO team1DTO;
    private TeamDTO team2DTO;
    private int allowedTeamSize;
    private String format;
}
