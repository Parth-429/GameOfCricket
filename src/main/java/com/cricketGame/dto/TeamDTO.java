package com.cricketGame.dto;

import com.cricketGame.validatorAnnotations.IsTeamExist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDTO {
    @NonNull @IsTeamExist
    private Long teamId;
    private int teamSize;
    @NotEmpty @Valid
    private List<PlayerDTO> players;
}
