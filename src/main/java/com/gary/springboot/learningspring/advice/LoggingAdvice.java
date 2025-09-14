package com.gary.springboot.learningspring.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {
    @Pointcut("execution(* com.gary.springboot.learningspring.business.ReservationService.*(..))")
    private void logPointcut() {
    }

    @Before("logPointcut()")
    public void logRequest(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("Before Advice - class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
        log.info("Before Advice - Request Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
    }

//    @After("logPointcut()")
//    public void logResponse(JoinPoint joinPoint) throws JsonProcessingException {
//        log.info("After Advice - class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
//        log.info("After Advice - Request Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
//    }

    @AfterReturning(value = "execution (* com.gary.springboot.learningspring.business.ReservationService.*(..))")
    public void logReturnResponse(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("AfterReturning Advice - LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
        log.info("AfterReturning Advice - LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
    }


    @AfterThrowing(value = "execution (* com.gary.springboot.learningspring.business.ReservationService.*(..))")
    public void logError(JoinPoint joinPoint) throws JsonProcessingException {
        log.info("Throws Advice - LoggingAdvice::logResponse class name {} ,method name {} ", joinPoint.getTarget(), joinPoint.getSignature().getName());
        log.info("Throws Advice - LoggingAdvice::logResponse Response Body {} ", new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
    }
}
