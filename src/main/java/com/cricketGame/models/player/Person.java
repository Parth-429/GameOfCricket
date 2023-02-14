package com.cricketGame.models.player;

import com.cricketGame.models.Bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person extends Bean {
    private String firstName;
    private String lastName;
    private int age;
}
