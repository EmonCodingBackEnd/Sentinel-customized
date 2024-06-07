package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.degrade;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRuleProvider;

/**
 * Authority RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("degradeRuleProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperDegradeRuleProvider extends ZookeeperRuleProvider<DegradeRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.DEGRADE_DATA_ID_POSTFIX;
    }
}
