package com.CricketGame.services.daoServices;

import com.cricketGame.dto.PersonDTO;
import com.cricketGame.mappers.PersonMapper;
import com.cricketGame.models.beans.player.Person;
import com.cricketGame.repository.PersonRepository;
import com.cricketGame.services.daoServices.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @Mock
    PersonRepository personRepository;
    @Spy
    PersonMapper personMapper;
    @InjectMocks
    PersonService personService;
    @Captor
    ArgumentCaptor<Person> person;
    @Test
    void savePerson() {
        //given
        PersonDTO personDTO = new PersonDTO("Parth","Prajapati", 19);
        //when
        personService.savePerson(personDTO);
        //Assertion
        verify(personRepository).save(person.capture());
    }

    @Test
    void findPlayerByID(){
        //given
        Person expectedPerson = new Person("Parth","Prajapati", 19);
        when(personRepository.findById(anyLong())).thenReturn(Optional.of(expectedPerson));
        //when
        Person actualPerson = personService.findPersonById(1L);
        //assertion
        verify(personRepository).findById(1L);
        assertEquals(expectedPerson,actualPerson);
    }
}