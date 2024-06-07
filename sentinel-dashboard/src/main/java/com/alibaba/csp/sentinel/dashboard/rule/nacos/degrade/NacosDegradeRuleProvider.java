package com.alibaba.csp.sentinel.dashboard.rule.nacos.degrade;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRuleProvider;

/**
 * Authority RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("degradeRuleProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosDegradeRuleProvider extends NacosRuleProvider<DegradeRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.DEGRADE_DATA_ID_POSTFIX;
    }
}
