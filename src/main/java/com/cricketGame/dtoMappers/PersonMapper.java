package com.cricketGame.dtoMappers;

import com.cricketGame.dto.PersonDTO;
import com.cricketGame.models.player.Person;
import com.cricketGame.services.generators.ObjectIDGenerator;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public PersonDTO toDto(Person person){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        personDTO.setAge(person.getAge());
        return personDTO;
    }
    public Person toPerson(PersonDTO personDTO){
        Long id = ObjectIDGenerator.getID();
        String firstName = personDTO.getFirstName();
        String lastName = personDTO.getLastName();
        int age = personDTO.getAge();
        return new Person(id,firstName, lastName, age);
    }
}
