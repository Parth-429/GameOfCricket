package com.cricketGame.services.daoServices;

import com.cricketGame.dto.PersonDTO;
import com.cricketGame.dto.PlayerDTO;
import com.cricketGame.dtoMappers.PersonMapper;
import com.cricketGame.dtoMappers.PlayerMapper;
import com.cricketGame.models.player.Person;
import com.cricketGame.models.player.Player;
import com.cricketGame.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
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
        try {
            if (!checkPerson.isPresent())
                throw new IllegalArgumentException("Error : Person with given id is not exist");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return checkPerson.get();
    }
}
