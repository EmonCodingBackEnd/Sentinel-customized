package com.alibaba.csp.sentinel.dashboard.rule.nacos.authority;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosRuleProvider;

/**
 * Authority RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("authorityRuleProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosAuthorityRuleProvider extends NacosRuleProvider<AuthorityRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return NacosConfigUtil.AUTHORITY_DATA_ID_POSTFIX;
    }
}
