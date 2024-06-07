package com.alibaba.csp.sentinel.dashboard.rule.zookeeper.param;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperConfigUtil;
import com.alibaba.csp.sentinel.dashboard.rule.zookeeper.ZookeeperRulePublisher;

/**
 * Authority RulePublisher
 * 
 * @author emon
 * @since 20240604
 **/
@Component("paramFlowRulePublisher")
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "zk")
public class ZookeeperParamFlowRulePublisher extends ZookeeperRulePublisher<ParamFlowRuleEntity> {

    @Override
    public String getDataIdPostfix() {
        return ZookeeperConfigUtil.PARAM_FLOW_DATA_ID_POSTFIX;
    }
}
