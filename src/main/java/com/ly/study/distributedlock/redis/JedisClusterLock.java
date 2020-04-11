package com.ly.study.distributedlock.redis;

import com.ly.study.distributedlock.AbstractLock;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * 基于JedisCluster 实现分布式锁
 */
@Service
public class JedisClusterLock extends AbstractLock {

    private JedisCluster jedisCluster;

    public JedisClusterLock(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    @Override
    protected boolean getLock(String key, int expire) {
        return OK.equalsIgnoreCase(jedisCluster.set(key, OK, NX, EX, expire));
    }

    @Override
    protected void del(String key) {
        this.jedisCluster.del(key);
    }

}
