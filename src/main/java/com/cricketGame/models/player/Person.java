package com.cricketGame.models.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private long personID;
    private String firstName;
    private String lastName;
    private int age;

}
