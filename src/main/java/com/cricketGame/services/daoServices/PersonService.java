package com.cricketGame.services.daoServices;

import com.cricketGame.dto.PersonDTO;
import com.cricketGame.mappers.PersonMapper;
import com.cricketGame.models.beans.player.Person;
import com.cricketGame.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;
    public Person savePerson(PersonDTO personDTO){
        Person person = this.personMapper.toPerson(personDTO);
        return this.personRepository.save(person);
    }
    public Person findPersonById(Long id){
        Optional<Person> checkPerson = this.personRepository.findById(id);
        return checkPerson.orElse(null);
    }
    public List<Person> findPersonByName(String firstName, String lastName){
        List<Person> persons = this.personRepository.findByFirstNameAndLastName(firstName,lastName);
        if(Objects.isNull(persons)) return Collections.emptyList();
        return persons;
    }
}
