package com.cricketGame.controller;

import com.cricketGame.dto.PersonDTO;
import com.cricketGame.dtoMappers.PersonMapper;
import com.cricketGame.models.player.Person;
import com.cricketGame.services.daoServices.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonMapper personMapper;
    @PostMapping
    public PersonDTO addPerson(@RequestBody PersonDTO personDTO){
        Person person = this.personService.savePerson(personDTO);
        return this.personMapper.toDto(person);
    }
}
