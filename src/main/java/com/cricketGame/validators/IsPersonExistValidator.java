package com.cricketGame.validators;

import com.cricketGame.models.beans.player.Person;
import com.cricketGame.services.daoServices.AllService;
import com.cricketGame.validatorAnnotations.IsPersonExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class IsPersonExistValidator implements ConstraintValidator<IsPersonExist, Long> {

    @Override
    public void initialize(IsPersonExist constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long personID, ConstraintValidatorContext context) {
        if(Objects.isNull(personID))
            return false;
        Person person = AllService.personService.findPersonById(personID);
        return !Objects.isNull(person);
    }
}
