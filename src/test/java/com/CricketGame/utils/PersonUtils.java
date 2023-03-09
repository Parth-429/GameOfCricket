package com.CricketGame.utils;

import com.cricketGame.models.beans.player.Person;
import com.cricketGame.models.beans.player.Player;
import com.cricketGame.services.generators.ObjectIDGenerator;

import java.util.ArrayList;
import java.util.List;

public class PersonUtils {
    public static Person getPerson(String firstName, String lastName, int age) {
        return new Person(ObjectIDGenerator.getID(), firstName, lastName, age);
    }
    public static List<Person> getListOfPerson(){
        List<Person> persons = new ArrayList<>();
        persons.add(getPerson("Parth", "Prajapati", 24));
        persons.add(getPerson("Parth", "Prajapati", 24));
        return persons;
    }
}
