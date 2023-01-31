package com.example.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = MyRuleValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRule {
String message() default "Kurs kodu MY ile bashlamalidir !";
Class<? extends Payload> [] payload() default {};
Class<?> [] groups() default {};
}
