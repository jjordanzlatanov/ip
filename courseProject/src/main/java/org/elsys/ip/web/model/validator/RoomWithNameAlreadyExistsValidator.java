package org.elsys.ip.web.model.validator;

import org.elsys.ip.model.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoomWithNameAlreadyExistsValidator implements ConstraintValidator<ValidRoomWithNameAlreadyExists, String> {
    @Autowired
    private RoomRepository repository;

    @Override
    public void initialize(ValidRoomWithNameAlreadyExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context){
        return repository.findByName(name).isEmpty();
    }
}