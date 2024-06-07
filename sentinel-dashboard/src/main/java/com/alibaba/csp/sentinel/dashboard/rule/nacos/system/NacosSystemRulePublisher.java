package com.alibaba.csp.sentinel.dashboard.rule.nacos.system;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.SystemRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRulePublisher;

/**
 * Authority RulePublisher
 * 
 * @author emon
 * @since 20240604
 **/
@Component("systemRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosSystemRulePublisher extends NacosRulePublisher<SystemRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.SYSTEM_DATA_ID_POSTFIX;
    }
}
