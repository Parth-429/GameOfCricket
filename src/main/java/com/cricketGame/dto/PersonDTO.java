package com.cricketGame.dto;

import com.cricketGame.validatorAnnotations.Age;
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
public class PersonDTO {
    @NotNull(message = "first name should not be null")
    private String firstName;
    @NotNull(message = "last name should not be null")
    private String lastName;
    @Age
    private int age;
}
