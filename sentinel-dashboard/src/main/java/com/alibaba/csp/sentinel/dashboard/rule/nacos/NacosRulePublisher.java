package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.SentinelDataSourceProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;

/**
 * Nacos RulePublisher 抽象类
 * 
 * @author emon
 * @since 1.8.6.1
 **/
public abstract class NacosRulePublisher<T extends RuleEntity> implements DynamicRulePublisher<List<T>> {

    @Autowired
    private SentinelDataSourceProperties dataSourceProperties;
    @Autowired
    protected ConfigService configService;
    @Autowired
    protected Converter<List<T>, String> converter;

    @Override
    public void publish(String app, List<T> rules) throws Exception {
        NacosDataSourceProperties nacos = dataSourceProperties.getNacos();
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }
        configService.publishConfig(app + getDataIdPostfix(), nacos.getGroupId(), converter.convert(rules));
    }

    /**
     * dataId 后缀，参考 com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil
     * 
     * @return dataId 后缀
     */
    public abstract String getDataIdPostfix();
}
