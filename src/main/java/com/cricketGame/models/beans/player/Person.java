package com.cricketGame.models.beans.player;

import com.cricketGame.models.beans.Bean;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@Entity
@Table(indexes = @Index(name = "hello", columnList = "firstName"))
public class Person extends Bean implements Serializable {

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
