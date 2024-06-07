package com.alibaba.csp.sentinel.dashboard.rule.zookeeper;

public class ZookeeperDataSourceProperties {
    private String serverAddr = "localhost:2181";

    private String path;
    /**
     * 默认 {@link ZookeeperConfigUtil#GROUP_ID}
     */
    private String groupId = ZookeeperConfigUtil.GROUP_ID;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}
