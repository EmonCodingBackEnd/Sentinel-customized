package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.authority;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.AuthorityRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRuleProvider;

/**
 * Authority RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("authorityRuleProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperAuthorityRuleProvider extends ZookeeperRuleProvider<AuthorityRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.AUTHORITY_DATA_ID_POSTFIX;
    }
}
