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

    /**
     * It stores the information about person into database
     * @param personDTO Create person object and make available person to play as player. It needs first name, last
     *                  name and age to be passed. It will generate unique id for person and store person in database
     * @return person information if it is created or else throw internal server error
     */
    @PostMapping("/")
    public ResponseEntity<PersonDTO> addPerson(@Valid @RequestBody PersonDTO personDTO){
        Person person = this.personService.savePerson(personDTO);
        return ResponseEntity.ok(personMapper.toPersonDto(person));
    }

    /**
     * It will find person by their names and return list of persons that matches to given name
     * @param firstName String that contains first name of person
     * @param lastName String that contains last name of person
     * @return list of persons whose name match with given parameter or else return emptyList
     */
    @GetMapping("/name/{fName}/{lName}/")
    public ResponseEntity<List<Person>> findPersonByName(@PathVariable(name = "fName") String firstName,
                                         @PathVariable(name = "lName") String lastName){
        return ResponseEntity.ok(this.personService.findPersonByName(firstName,lastName));
    }
}
