package com.cricketGame.services.daoServices;

import com.cricketGame.dto.PersonDTO;
import com.cricketGame.models.beans.player.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(PersonDTO personDTO);
    Person findPersonById(Long id);
    List<Person> findPersonByName(String firstName, String lastName);
}
