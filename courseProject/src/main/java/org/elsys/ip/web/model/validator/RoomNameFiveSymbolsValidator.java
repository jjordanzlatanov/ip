package org.elsys.ip.web.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomNameFiveSymbolsValidator implements ConstraintValidator<ValidRoomNameFiveSymbols, String> {
    @Override
    public void initialize(ValidRoomNameFiveSymbols constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context){
        return name.length() >= 5;
    }
}