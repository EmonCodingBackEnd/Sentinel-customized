package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.flow;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRuleProvider;

/**
 * Authority RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("flowRuleProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperFlowRuleProvider extends ZookeeperRuleProvider<FlowRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.FLOW_DATA_ID_POSTFIX;
    }
}
