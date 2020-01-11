package com.ly.study.rateLimit.config;

import com.ly.study.rateLimit.config.data.LeakyBucket;
import com.ly.study.rateLimit.config.data.TokenBucket;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RateLimitAutoConfiguration
 * @Author liuyang
 * @Date 2020-01-11 14:46
 **/

@Data
@Configuration
@ConfigurationProperties(prefix = "ratelimit.config")
public class RateLimitConfiguration {

    private LeakyBucket leakyBucket;

    private TokenBucket tokenBucket;

}
