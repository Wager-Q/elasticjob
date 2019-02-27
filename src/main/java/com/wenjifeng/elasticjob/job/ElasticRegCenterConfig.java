package com.wenjifeng.elasticjob.job;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @className ElasticRegCenterConfig
 * @Author wen_jf@suixingpay
 * @Date 2019/2/15 14:07
 * @Version 1.0
 **/
@Configuration
public class ElasticRegCenterConfig {

    private final String serverList = "你的zookeeperIP地址:端口号";
    private final String namespace = "elastic-job-lite-springboot";
    // 初始化zookeeper
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter() {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }
}
