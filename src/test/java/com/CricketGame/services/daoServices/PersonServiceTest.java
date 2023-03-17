package com.CricketGame.services.daoServices;

import com.CricketGame.utils.DtoUtils;
import com.CricketGame.utils.PersonUtils;
import com.cricketGame.dto.PersonDTO;
import com.cricketGame.mappers.PersonMapper;
import com.cricketGame.models.beans.player.Person;
import com.cricketGame.repository.PersonRepository;
import com.cricketGame.services.daoServicesImpl.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @Mock
    PersonRepository personRepository;
    @Mock
    PersonMapper personMapper;
    @InjectMocks
    PersonService personService;
    @Test
    void savePerson() {
        //given
        PersonDTO personDTO = DtoUtils.getPersonDTO();
        Person person = PersonUtils.getPerson("Parth","Prajapati", 24);
        when(personMapper.toPerson(any(PersonDTO.class))).thenReturn(person);
        when(personRepository.save(any(Person.class))).thenReturn(person);
        //when
        Person actualPerson = personService.savePerson(personDTO);
        //Assertion
        assertEquals(person, actualPerson);
    }

    @Test
    void findPlayerByID_WhenValidPersonId(){
        //given
        Person expectedPerson = PersonUtils.getPerson("Parth","Prajapati", 24);
        when(personRepository.findById(anyLong())).thenReturn(Optional.of(expectedPerson));
        //when
        Person actualPerson = personService.findPersonById(1L);
        //assertion
        assertEquals(expectedPerson,actualPerson);
    }

    @Test
    void findPlayerByID_WhenPersonIdIsNotValid(){
        //given
        when(personRepository.findById(anyLong())).thenReturn(Optional.ofNullable(null));
        //when
        Person actualPerson = personService.findPersonById(1L);
        //assertion
        assertNull(actualPerson);
    }
    @Test
    void findPersonByName_WhenPersonExist(){
        List<Person> personList = PersonUtils.getListOfPerson();
        String firstName = "Parth", lastName = "Prajapati";
        when(personRepository.findByFirstNameAndLastName(anyString(),anyString())).thenReturn(personList);

        List<Person> actualPerosnList = personService.findPersonByName(firstName,lastName);

        assertEquals(personList, actualPerosnList);
    }

    @Test
    void findPersonByName_WhenPersonNotExist(){
        String firstName = "Parth", lastName = "Prajapati";
        when(personRepository.findByFirstNameAndLastName(anyString(),anyString())).thenReturn(Collections.emptyList());

        List<Person> actualPerosnList = personService.findPersonByName(firstName,lastName);

        assertTrue(actualPerosnList.isEmpty());
    }
}