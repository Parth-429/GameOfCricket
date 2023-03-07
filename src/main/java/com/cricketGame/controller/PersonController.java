package com.cricketGame.controller;

import com.cricketGame.dto.PersonDTO;
import com.cricketGame.mappers.PersonMapper;
import com.cricketGame.models.beans.player.Person;
import com.cricketGame.services.daoServices.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private PersonMapper personMapper;
    @PostMapping("/")
    public ResponseEntity<PersonDTO> addPerson(@Valid @RequestBody PersonDTO personDTO){
        Person person = this.personService.savePerson(personDTO);
        return ResponseEntity.ok(personMapper.toPersonDto(person));
    }
    @GetMapping("/name/{fName}/{lName}/")
    public List<Person> findPersonByName(@PathVariable(name = "fName") String firstName,
                                         @PathVariable(name = "lName") String lastName){
        return this.personService.findPersonByName(firstName,lastName);
    }
}
