package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.degrade;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRulePublisher;

/**
 * Authority RulePublisher
 * 
 * @author emon
 * @since 20240604
 **/
@Component("degradeRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperDegradeRulePublisher extends ZookeeperRulePublisher<DegradeRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.DEGRADE_DATA_ID_POSTFIX;
    }
}
