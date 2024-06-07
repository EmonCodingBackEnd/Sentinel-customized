package com.alibaba.csp.sentinel.dashboard.rule.redis;

import java.time.Duration;
import java.util.List;

/**
 * @author emon
 * @since 1.8.6.1
 */
public class RedisDataSourceProperties {

    /**
     * redis server host.
     */
    private String host = "localhost";

    /**
     * redis server port.
     */
    private int port = 6379;

    /**
     * redis server password.
     */
    private String password;

    /**
     * redis server default select database.
     */
    private int database;

    /**
     * redis server timeout.
     */
    private Duration timeout;

    /**
     * Comma-separated list of "host:port" pairs.
     */
    private List<String> nodes;

    /**
     * data key in Redis.
     */
    private String ruleKey;

    /**
     * channel to subscribe in Redis.
     */
    private String channel;

    /**
     * redis sentinel model.
     */
    private String masterId;
}
