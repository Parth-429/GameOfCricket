package com.cricketGame.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTO {
    private Long team1Id;
    private Long team2Id;
    private int allowedTeamSize;
    private String format;
}
