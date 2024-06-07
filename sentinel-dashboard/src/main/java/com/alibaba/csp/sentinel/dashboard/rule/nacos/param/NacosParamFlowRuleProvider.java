package com.alibaba.csp.sentinel.dashboard.rule.nacos.param;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRuleProvider;

/**
 * Authority RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("paramFlowRuleProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosParamFlowRuleProvider extends NacosRuleProvider<ParamFlowRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX;
    }
}
