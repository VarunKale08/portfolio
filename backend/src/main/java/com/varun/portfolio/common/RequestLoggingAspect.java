package com.varun.portfolio.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequestLoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(RequestLoggingAspect.class);

    // Pointcut: any method of any class annotated with @RestController.
    @Around("within(@org.springframework.web.bind.annotation.RestController *)")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().toShortString();
        long start = System.nanoTime();
        try {
            Object result = joinPoint.proceed();   // run the real controller method
            log.info("{} completed in {} ms", method, elapsedMs(start));
            return result;
        } catch (Throwable ex) {
            log.warn("{} failed after {} ms: {}", method, elapsedMs(start), ex.getMessage());
            throw ex;                              // let GlobalExceptionHandler deal with it
        }
    }

    private static long elapsedMs(long start) {
        return (System.nanoTime() - start) / 1_000_000;
    }
}