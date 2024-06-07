package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.system;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRulePublisher;

/**
 * Authority RulePublisher
 * 
 * @author emon
 * @since 20240604
 **/
@Component("systemRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperSystemRulePublisher extends ZookeeperRulePublisher<SystemRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.SYSTEM_DATA_ID_POSTFIX;
    }
}
