package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.gateway;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRulePublisher;

/**
 * 网关 RulePublisher
 * @author emon
 * @since 20240604
 **/
@Component("gatewayFlowRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperGatewayFlowRulePublisher extends ZookeeperRulePublisher<GatewayFlowRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.GATEWAY_FLOW_DATA_ID_POSTFIX;
    }
}

