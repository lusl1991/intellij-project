package com.softel.aspect;

import com.softel.model.utils.Response;
import com.softel.service.exception.ServiceException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: lsl
 * @description:
 * @date: Created in 15:38 2018/1/15
 * @modified By:
 */
@Aspect
public class ServiceExceptionAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceExceptionAspect.class);

    /**
     * @within(org.springframework.stereotype.Service)，拦截带有 @Service 注解的类的所有方法
     * @annotation(org.springframework.web.bind.annotation.RequestMapping)，拦截带有@RquestMapping的注解方法
     */
    @Pointcut("@within(org.springframework.stereotype.Service) && execution(public * *(..))")
    private void servicePointcut() {}

    @Before("execution(* *.*(..)))")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.warn(className + "的" + methodName + "执行了");
        Object[] args = joinPoint.getArgs();
        StringBuilder log = new StringBuilder("入参为");
        for (Object arg : args) {
            log.append(arg + " ");
        }
        logger.warn(log.toString());
    }

    @AfterReturning(value = "execution(* *.*(..)))", returning = "returnVal")
    public void afterReturin(Object returnVal) {
        logger.warn("方法正常结束了,方法的返回值:" + returnVal);
    }

    @AfterThrowing(value = "ServiceExceptionAspect.servicePointcut()", throwing = "e")
    public void afterThrowing(Throwable e) {
        if (e instanceof ServiceException) {
            logger.error("通知中发现异常ServiceException", e);
        } else {
            logger.error("通知中发现未知异常", e);
        }
    }

    @Around(value = "ServiceExceptionAspect.servicePointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.warn("前置增强...");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            return new Response().failure(e.getMessage());
        }
        return result;
    }

    public void throwingMethod(JoinPoint joinPoint) throws Throwable {
    }
}
