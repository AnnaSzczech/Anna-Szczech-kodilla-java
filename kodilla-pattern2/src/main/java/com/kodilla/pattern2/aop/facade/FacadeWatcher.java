package com.kodilla.pattern2.aop.facade;

import com.kodilla.pattern2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.pattern2.aop.calculator.Watcher.class);
    private long timeConsumed;

    @Before("execution(* com.kodilla.pattern2.facade.api.OrderFacade.processOrder(..)) && args(order, userId) && target(object)")
    public void logEvent(OrderDto order, Long userId, Object object){
        LOGGER.info("Class" + object.getClass().getName() + ", Order: " + order + ", User Id:" + userId);
    }

    @Around("execution(* com.kodilla.pattern2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            timeConsumed = end - begin;
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @After("execution(* com.kodilla.pattern2.facade.api.OrderFacade.processOrder(..)) && target(object)")
    public void logEvent(Object object){
        LOGGER.info("Class" + object.getClass().getName() + "  Time consumed: " + timeConsumed + "[ms]");
    }
}
