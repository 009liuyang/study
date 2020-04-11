package com.ly.study.distributedlock.annotation;

import java.lang.annotation.*;

/**
 * @desc
 * @Author liuyang
 * @Date 2020-01-13 17:41
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedLock {
    /**
     * 锁的key,支持Spring EL表达式。
     *
     * @return
     */
    String key() default "";

    /**
     * 锁的租约时间，单位是秒，默认120秒。当前线程在获取到锁以后，在租约时间到期以后，会自动释放锁。如果在租约时间到期之前，方法执行完毕了，也会释放锁。
     *
     * @return
     */
    int leaseTime() default 120;

    /**
     * 尝试次数。如果尝试了指定的次没有获取到就立即抛出异常。<br>
     *
     * @return
     */
    int tryCnt() default 0;

    /**
     * 尝试重新获取锁的时间间隔，单位是毫秒，默认为10。
     *
     * @return
     */
    int interval() default 10;

    /**
     * 如果获取分布式锁失败时，快速失败的方法。<br>
     * 注意：参数和返回值类型必须与当前方法完全一样。<br>
     * 如果没有设置fallbackMethod，则抛出异常。
     *
     * @return
     */
    String fallbackMethod() default "";

    /**
     * 业务状态缓存的过期时间，单位：秒，如果为0则表示永久缓存
     *
     * @return 时间
     */
    int businessStatusExpire() default 120;
}
