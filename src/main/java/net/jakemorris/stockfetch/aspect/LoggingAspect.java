package net.jakemorris.stockfetch.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* net.jakemorris.stockfetch.controller..*(..))")
    public void logEnpoints(JoinPoint jointPoint) {
        logger.info("=========== Controller LOGGER ===========");
        logger.info(jointPoint.getSignature());
    }

    @Before("execution(* net.jakemorris.stockfetch.service..*(..))")
    public void logServices(JoinPoint jointPoint) {
        logger.info("=========== Service LOGGER ===========");
        logger.info(jointPoint.getSignature());
    }

    @Before("execution(* net.jakemorris.stockfetch.dao..*(..))")
    public void logTransactions(JoinPoint jointPoint) {
        logger.info("=========== DAO LOGGER ===========");
        logger.info(jointPoint.getSignature());
    }
}
