package com.cricketGame.models.player;

import com.cricketGame.models.Bean;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@MappedSuperclass
public class Person extends Bean {
    private String firstName;
    private String lastName;
    private int age;
}
