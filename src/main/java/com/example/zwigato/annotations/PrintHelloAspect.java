package com.example.zwigato.annotations;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintHelloAspect {

    @Before("@annotation(printHello)")
    public void PrintHello(PrintHello printHello)
    {
        System.out.println("Hello "+printHello.value());
    }

}
