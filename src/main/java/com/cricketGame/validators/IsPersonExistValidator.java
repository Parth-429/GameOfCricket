package com.cricketGame.validators;

import com.cricketGame.models.beans.player.Person;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.validatorAnnotations.ValidPersonId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class IsPersonExistValidator implements ConstraintValidator<ValidPersonId, Long> {

    @Override
    public void initialize(ValidPersonId constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long personID, ConstraintValidatorContext context) {
        if(Objects.isNull(personID))
            return false;
        Person person = AllService.personService.findPersonById(personID);
        return !Objects.isNull(person);
    }
}
