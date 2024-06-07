package com.alibaba.csp.sentinel.dashboard.rule.nacos.param;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRulePublisher;

/**
 * Authority RulePublisher
 * 
 * @author emon
 * @since 20240604
 **/
@Component("paramFlowRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosParamFlowRulePublisher extends NacosRulePublisher<ParamFlowRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX;
    }
}
