package com.ly.study.distributedlock;

import com.ly.study.distributedlock.annotation.DistributedLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @desc
 * @Author liuyang
 * @Date 2020-01-13 17:48
 **/
@Service
public class DistributedLockHandler {

    @Autowired
    private IDistributedLock distributedLock;

    public Object proceed(ProceedingJoinPoint invocation, DistributedLock lockAnnotation) throws Throwable {

        Object args[] = invocation.getArgs();
        Method method = getMethod(invocation);
        String key = lockAnnotation.key();

        try {
            // 尝试获取分布式锁
            if (!distributedLock.tryLock(key, lockAnnotation.leaseTime(), lockAnnotation.tryCnt(), lockAnnotation.interval())) {
                return fallback(invocation, lockAnnotation, key);
            }

            return invocation.proceed();
        }catch (Exception e){
            throw e;
        }finally {
            distributedLock.release(key);
        }
    }


    /**
     * @param invocation
     * @return
     */
    public Method getMethod(ProceedingJoinPoint invocation) {
        Signature signature = invocation.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        return methodSignature.getMethod();
    }


    /**
     * @param invocation
     * @param lockAnnotation
     * @param key
     * @return
     * @throws Throwable
     */
    private Object fallback(ProceedingJoinPoint invocation, DistributedLock lockAnnotation, String key) throws Throwable {
        String fallbackMethodName = lockAnnotation.fallbackMethod();
        if (null != fallbackMethodName && fallbackMethodName.trim().length() > 0) {
            Method invMethod = getMethod(invocation);
            Object target = invocation.getTarget();
            Method fallbackMethod = target.getClass().getMethod(fallbackMethodName, invMethod.getParameterTypes());
            if (null != fallbackMethod && invMethod.getReturnType().equals(fallbackMethod.getReturnType())) {
                return fallbackMethod.invoke(target, invocation.getArgs());
            }
        }
        throw new RuntimeException("does not acquire distributed lock for [" + key + "]");
    }

}
