package com.alibaba.csp.sentinel.dashboard.rule.zookeeper;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.rule.SentinelDataSourceProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;

/**
 * Nacos RulePublisher 抽象类
 * 
 * @author emon
 * @since 1.8.6.1
 **/
public abstract class ZookeeperRulePublisher<T extends RuleEntity> implements DynamicRulePublisher<List<T>> {

    @Autowired
    private SentinelDataSourceProperties dataSourceProperties;
    @Autowired
    private CuratorFramework zkClient;
    @Autowired
    protected Converter<List<T>, String> converter;

    @Override
    public void publish(String app, List<T> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        ZookeeperDataSourceProperties zk = dataSourceProperties.getZk();

        String path = ZookeeperConfigUtil.getPath(zk.getGroupId(), app + getDataIdPostfix());
        Stat stat = zkClient.checkExists().forPath(path);
        if (stat == null) {
            zkClient.create().creatingParentContainersIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, null);
        }
        byte[] data = CollectionUtils.isEmpty(rules) ? "[]".getBytes() : converter.convert(rules).getBytes();
        zkClient.setData().forPath(path, data);
    }

    /**
     * dataId 后缀，参考 com.alibaba.csp.sentinel.dashboard.rule.nacos.NacosConfigUtil
     * 
     * @return dataId 后缀
     */
    public abstract String getDataIdPostfix();
}
