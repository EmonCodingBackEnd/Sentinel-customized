package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.param;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRuleProvider;

/**
 * Authority RuleProvider
 * 
 * @author emon
 * @since 20240604
 **/
@Component("paramFlowRuleProvider")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperParamFlowRuleProvider extends ZookeeperRuleProvider<ParamFlowRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX;
    }
}
