package com.zking.ssm.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class MyLogAspect {

    @Pointcut("@annotation(com.zking.ssm.annotation.MyLog)")
    private void MyValid() {
    }

    @Before("MyValid()")
    public void before(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method:methods){
            if(method.getName().equals(methodName)){
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length){
                    description = method.getAnnotation(MyLog.class).desc();
                      log.debug("[" + joinPoint.getSignature().getName() + " "+description+" : start.....]");
                }
            }
        }
        //log.debug(myLog.desc() + "[" + joinPoint.getSignature().getName() + " : start.....]");
    }
}
