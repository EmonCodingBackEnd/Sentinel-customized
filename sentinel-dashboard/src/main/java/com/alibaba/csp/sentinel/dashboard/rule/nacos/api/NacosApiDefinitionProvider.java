package com.alibaba.csp.sentinel.dashboard.rule.nacos.api;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRuleProvider;

/**
 * Api RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("apiDefinitionProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosApiDefinitionProvider extends NacosRuleProvider<ApiDefinitionEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.GATEWAY_API_FLOW_DATA_ID_POSTFIX;
    }
}
