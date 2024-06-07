package com.alibaba.csp.sentinel.dashboard.rule.nacos.authority;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRulePublisher;

/**
 * Authority RulePublisher
 * 
 * @author emon
 * @since 20240604
 **/
@Component("authorityRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosAuthorityRulePublisher extends NacosRulePublisher<AuthorityRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX;
    }
}
