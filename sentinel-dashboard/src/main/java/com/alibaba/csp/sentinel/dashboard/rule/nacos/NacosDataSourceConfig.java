/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.rule.nacos;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.csp.sentinel.dashboard.rule.SentinelDataSourceConfig;
import com.alibaba.csp.sentinel.dashboard.rule.SentinelDataSourceProperties;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;

/**
 * @author emon
 * @since 1.8.6.1
 */
@Configuration
@ConditionalOnProperty(prefix = "sentinel.datasource", name = "provider", havingValue = "nacos")
public class NacosDataSourceConfig extends SentinelDataSourceConfig {

    @Autowired
    private SentinelDataSourceProperties dataSourceProperties;

    @Bean
    public ConfigService nacosConfigService() throws Exception {
        NacosDataSourceProperties nacos = dataSourceProperties.getNacos();
        Properties properties = new Properties();
        if (StringUtils.isNotBlank(nacos.getServerAddr())) {
            properties.put(PropertyKeyConst.SERVER_ADDR, nacos.getServerAddr());
        }
        if (StringUtils.isNotBlank(nacos.getNamespace())) {
            properties.put(PropertyKeyConst.NAMESPACE, nacos.getNamespace());
        }
        if (StringUtils.isNotBlank(nacos.getUsername())) {
            properties.put(PropertyKeyConst.USERNAME, nacos.getUsername());
        }
        if (StringUtils.isNotBlank(nacos.getPassword())) {
            properties.put(PropertyKeyConst.PASSWORD, nacos.getPassword());
        }
        if (StringUtils.isNotBlank(nacos.getAccessKey())) {
            properties.put(PropertyKeyConst.ACCESS_KEY, nacos.getAccessKey());
        }
        if (StringUtils.isNotBlank(nacos.getSecretKey())) {
            properties.put(PropertyKeyConst.SECRET_KEY, nacos.getSecretKey());
        }
        return ConfigFactory.createConfigService(properties);
    }
}
