package com.example.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MyRuleValidator implements ConstraintValidator<MyRule,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null){
            return false;
        }
        return value.startsWith("MY");
    } 
}
