package com.cricketGame.dto;


import com.cricketGame.models.enums.MatchFormat;
import com.cricketGame.validatorAnnotations.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.text.Format;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ValidAllowedTeamSize @DifferentTeams
public class MatchDTO {
    @NonNull @Valid @ValidTeamSize @MinimumBowlersRequirement @UniqueBattingOrderForAllPlayer
    private TeamDTO team1DTO;
    @NonNull @Valid @ValidTeamSize @MinimumBowlersRequirement @UniqueBattingOrderForAllPlayer
    private TeamDTO team2DTO;
    private int allowedTeamSize;
    private MatchFormat format;
}
