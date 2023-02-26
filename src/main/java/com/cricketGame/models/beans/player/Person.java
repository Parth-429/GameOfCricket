package com.cricketGame.models.beans.player;

import com.cricketGame.models.beans.Bean;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@Entity
public class Person extends Bean {
    private String firstName;
    private String lastName;
    private int age;
    public Person(Long id, String firstName, String lastName, int age) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}