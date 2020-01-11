package com.ly.study.cacheHelper.interceptor;

import com.ly.study.cacheHelper.annotation.Cache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class CacheInterceptor {

    @Pointcut("execution(* com.cache.mapper..*.*(..)) &amp;&amp; @annotation(cache))")
    public void cache(){}

    @Before("cache()")
    public void before(JoinPoint joinPoint){

        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(Cache.class)) {
            Cache cache = method.getAnnotation(Cache.class);

        }

    }

}
