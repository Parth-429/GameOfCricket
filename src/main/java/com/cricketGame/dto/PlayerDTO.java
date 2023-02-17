package com.cricketGame.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    String firstName;
    String lastName;
    String role;
    int age;
    int battingOrderNo;
}
