package com.example.mvc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

    @Before(value = "execution(public void addStudent(..))")
    public void before(){
        System.out.println("Before addStudent");
    }
}
