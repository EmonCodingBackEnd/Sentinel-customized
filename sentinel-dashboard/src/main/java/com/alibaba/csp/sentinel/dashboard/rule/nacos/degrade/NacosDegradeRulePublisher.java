package com.alibaba.csp.sentinel.dashboard.rule.nacos.degrade;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRulePublisher;

/**
 * Authority RulePublisher
 * 
 * @author emon
 * @since 20240604
 **/
@Component("degradeRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosDegradeRulePublisher extends NacosRulePublisher<DegradeRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.DEGRADE_DATA_ID_POSTFIX;
    }
}
