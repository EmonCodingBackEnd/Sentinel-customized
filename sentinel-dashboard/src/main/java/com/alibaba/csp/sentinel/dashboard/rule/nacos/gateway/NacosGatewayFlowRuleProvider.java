package com.alibaba.csp.sentinel.dashboard.rule.nacos.gateway;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRuleProvider;

/**
 * 网关 RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("gatewayFlowRuleProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosGatewayFlowRuleProvider extends NacosRuleProvider<GatewayFlowRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.GATEWAY_FLOW_DATA_ID_POSTFIX;
    }
}
