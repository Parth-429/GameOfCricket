package com.cricketGame.validators;

import com.cricketGame.models.beans.player.Person;
import com.cricketGame.services.daoServicesImpl.PersonServiceImpl;
import com.cricketGame.validatorAnnotations.ValidPersonId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class PersonIDValidator implements ConstraintValidator<ValidPersonId, Long> {

    @Autowired
    private PersonServiceImpl personService;

    @Override
    public void initialize(ValidPersonId constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long personID, ConstraintValidatorContext context) {
        if(Objects.isNull(personID))
            return false;
        Person person = personService.findPersonById(personID);
        return !Objects.isNull(person);
    }
}
