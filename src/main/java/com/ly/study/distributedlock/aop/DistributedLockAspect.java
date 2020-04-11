package com.ly.study.distributedlock.aop;

import com.ly.study.distributedlock.DistributedLockHandler;
import com.ly.study.distributedlock.annotation.DistributedLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @desc
 * @Author liuyang
 * @Date 2020-01-13 17:43
 **/
@Aspect
public class DistributedLockAspect {

    @Autowired
    private DistributedLockHandler distributedLockHandler;

    @Around("@annotation(lockAnnotation)")
    public Object doDistributedLockOperation(ProceedingJoinPoint invocation, DistributedLock lockAnnotation) throws Throwable {
        return distributedLockHandler.proceed(invocation, lockAnnotation);
    }
}
