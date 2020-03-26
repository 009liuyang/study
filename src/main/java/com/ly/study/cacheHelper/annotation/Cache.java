package com.ly.study.cacheHelper.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 缓存注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface Cache {


    /**
     * 缓存的过期时间，单位：秒，如果为0则表示永久缓存
     *
     * @return 时间
     */
    int expire();

    /**
     * 预警自动刷新时间(单位：秒)，必须满足 0 &lt; alarmTime &lt; expire才有效 当缓存在alarmTime
     * 时间内即将过期的话，会自动刷新缓存内容；
     *
     * @return 时间
     */
    int alarmTime() default 0;

    /**
     * 自定义缓存Key，支持表达式
     *
     * @return String 自定义缓存Key
     */
    String key();


    /**
     * 是否启用自动加载缓存， 缓存时间必须大于120秒时才有效
     * 如果magic为true时，会强制关闭自动加载功能
     *
     * @return boolean
     */
    boolean autoload() default false;

    /**
     * 缓存的操作类型：默认是READ_WRITE，先缓存取数据，如果没有数据则从DAO中获取并写入缓存；如果是WRITE则从DAO取完数据后，写入缓存
     *
     * @return CacheOpType
     */

    /**
     * 并发等待时间(毫秒),等待正在DAO中加载数据的线程返回的等待时间。
     *
     * @return 时间
     */
    int waitTimeOut() default 500;

    /**
     * 分布式锁的缓存时间（单位：秒），在设置分布式锁的前提下，如果此项值大于0，则会使用分布式锁，如果小于等于0，则不会使用分布式锁。
     *
     * @return 分布式锁的缓存时间
     */
    int lockExpire() default 10;

}