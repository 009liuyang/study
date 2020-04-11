package com.ly.study.rateLimit.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName RateLimitContext
 * @Author liuyang
 * @Date 2020-01-11 11:55
 **/
@Service
public class RateLimitContext {

    @Autowired
    private final Map<String, RateLimitStrategy> strategyMap = new ConcurrentHashMap<>();

    //将RateLimitStrategy的实现类注入到map里
    public RateLimitContext(Map<String, RateLimitStrategy> strategyMap) {
        this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
    }

    public boolean execute(String strategy) throws InterruptedException {
        RateLimitStrategy.LimitResult result = strategyMap.get(strategy).doRateLimit();

        if(result.isThrough()){
            result.getTimeUnit().sleep(result.getDuration());
            return true;
        }

        return false;
    }

}
