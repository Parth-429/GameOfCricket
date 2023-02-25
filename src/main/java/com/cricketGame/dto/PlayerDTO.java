package com.cricketGame.dto;


import com.cricketGame.models.enums.Role;
import com.cricketGame.validatorAnnotations.IsPersonExist;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerDTO {
    @NotNull @IsPersonExist
    private Long personId;
    @NonNull
    private Role role;
    private int battingOrderNo;
}
