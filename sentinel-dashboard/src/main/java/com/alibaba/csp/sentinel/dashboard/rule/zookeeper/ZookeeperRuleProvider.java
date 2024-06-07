package com.alibaba.csp.sentinel.dashboard.rule.zookeeper;

import java.util.ArrayList;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.rule.SentinelDataSourceProperties;
import com.alibaba.csp.sentinel.datasource.Converter;

/**
 * Nacos RuleProvider 抽象类
 * 
 * @author emon
 * @since 1.8.6.1
 **/
public abstract class ZookeeperRuleProvider<T extends RuleEntity> implements DynamicRuleProvider<List<T>> {

    @Autowired
    private SentinelDataSourceProperties dataSourceProperties;
    @Autowired
    private CuratorFramework zkClient;
    @Autowired
    protected Converter<String, List<T>> converter;

    @Override
    public List<T> getRules(String appName) throws Exception {
        ZookeeperDataSourceProperties zk = dataSourceProperties.getZk();
        String zkPath = ZookeeperConfigUtil.getPath(zk.getGroupId(), appName + getDataIdPostfix());
        Stat stat = zkClient.checkExists().forPath(zkPath);
        if (stat == null) {
            return new ArrayList<>(0);
        }
        byte[] bytes = zkClient.getData().forPath(zkPath);
        if (null == bytes || bytes.length == 0) {
            return new ArrayList<>();
        }
        String s = new String(bytes);

        return converter.convert(s);
    }

    /**
     * dataId 后缀，参考 com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil
     * 
     * @return dataId 后缀
     */
    public abstract String getDataIdPostfix();
}
