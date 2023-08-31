package com.example.mvcvalidation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    public String value() default "HELLO";
    public String message() default "Must starts with HELLO";


    //Grouping constriants
    public Class<?>[] groups() default { };


    //Provide custom details about validation failure (Severity level,error code,etc.)
    public Class<? extends Payload>[] payload() default { };
}
