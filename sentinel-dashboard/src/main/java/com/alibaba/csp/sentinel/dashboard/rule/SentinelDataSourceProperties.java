package com.alibaba.csp.sentinel.dashboard.rule;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosDataSourceProperties;
import com.alibaba.csp.sentinel.dashboard.rule.redis.RedisDataSourceProperties;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperDataSourceProperties;

@Configuration
@ConfigurationProperties(prefix = "sentinel.datasource")
public class SentinelDataSourceProperties {

    /**
     * nacos,zookeeper
     */
    private String provider;

    private NacosDataSourceProperties nacos;
    private ZookeeperDataSourceProperties zk;
    private RedisDataSourceProperties redis;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public NacosDataSourceProperties getNacos() {
        return nacos;
    }

    public void setNacos(NacosDataSourceProperties nacos) {
        this.nacos = nacos;
    }

    public ZookeeperDataSourceProperties getZk() {
        return zk;
    }

    public void setZk(ZookeeperDataSourceProperties zk) {
        this.zk = zk;
    }
}
