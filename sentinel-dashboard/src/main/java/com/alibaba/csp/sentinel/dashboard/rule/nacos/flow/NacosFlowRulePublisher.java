package com.alibaba.csp.sentinel.dashboard.rule.nacos.flow;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRulePublisher;

/**
 * Authority RulePublisher
 * @author emon
 * @since 20240604
 **/
@Component("flowRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosFlowRulePublisher extends NacosRulePublisher<FlowRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.FLOW_DATA_ID_POSTFIX;
    }
}

