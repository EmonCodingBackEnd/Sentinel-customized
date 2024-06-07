package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.SentinelDataSourceProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;

/**
 * Nacos RuleProvider 抽象类
 * 
 * @author emon
 * @since 1.8.6.1
 **/
public abstract class NacosRuleProvider<T extends RuleEntity> implements DynamicRuleProvider<List<T>> {

    @Autowired
    private SentinelDataSourceProperties dataSourceProperties;
    @Autowired
    protected ConfigService configService;
    @Autowired
    protected Converter<String, List<T>> converter;

    @Override
    public List<T> getRules(String appName) throws Exception {
        NacosDataSourceProperties nacos = dataSourceProperties.getNacos();
        String rules = configService.getConfig(appName + getDataIdPostfix(), nacos.getGroupId(), 3000);
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return converter.convert(rules);
    }

    /**
     * dataId 后缀，参考 com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil
     * 
     * @return dataId 后缀
     */
    public abstract String getDataIdPostfix();
}
