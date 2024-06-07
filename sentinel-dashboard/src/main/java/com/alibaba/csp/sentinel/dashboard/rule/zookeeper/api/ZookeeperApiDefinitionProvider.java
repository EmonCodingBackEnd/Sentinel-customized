package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRuleProvider;

/**
 * Api RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("apiDefinitionProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperApiDefinitionProvider extends ZookeeperRuleProvider<ApiDefinitionEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.GATEWAY_API_FLOW_DATA_ID_POSTFIX;
    }
}
