package com.ly.study.distributedlock.redis;

import com.ly.study.distributedlock.AbstractLock;
import io.lettuce.core.SetArgs;
import io.lettuce.core.cluster.RedisClusterClient;
import org.springframework.stereotype.Service;

/**
 * 基于RedisClusterClient 实现分布式锁
 */
@Service
public class LettuceClusterLock extends AbstractLock {

    private RedisClusterClient clusterClient;

    public LettuceClusterLock(RedisClusterClient clusterClient) {
        this.clusterClient = clusterClient;
    }

    @Override
    protected boolean getLock(String key, int expire) {
        SetArgs setArgs = new SetArgs();
        setArgs.nx();
        setArgs.ex(expire);
        return OK.equalsIgnoreCase(clusterClient.connect().sync().set(key, OK, setArgs));
    }

    @Override
    protected void del(String key) {
        this.clusterClient.connect().async().del(key);
    }

}
