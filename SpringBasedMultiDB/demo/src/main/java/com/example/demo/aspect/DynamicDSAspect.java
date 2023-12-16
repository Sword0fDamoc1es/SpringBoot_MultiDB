package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.demo.DynamicDataSource2;
import com.example.demo.annotation.WR;

@Component
@Aspect
public class DynamicDSAspect {
    @Before("within(com.example.demo.service.*) && @annotation(wr)")
    public void before(JoinPoint point, WR wr){
        String name = wr.value();
        DynamicDataSource2.currentDataSource.set(name);    
        // System.out.println(name);
    }
}