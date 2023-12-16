package com.example.demo.annotation;

import java.lang.annotation.ElementType; // Add this import statement
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface WR {
    String value() default "w";
}
