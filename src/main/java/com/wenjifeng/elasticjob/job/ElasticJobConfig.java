package com.wenjifeng.elasticjob.job;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @className ElasticJobConfig
 * @Author wen_jf@suixingpay
 * @Date 2019/2/15 14:22
 * @Version 1.0
 **/
@Configuration
public class ElasticJobConfig {

    @Autowired
    private ZookeeperRegistryCenter regCenter;

    private final String shardingItemParameters = "0=0,1=1";
    private final String cron = "0/5 * * * * ?";
    private final int shardingTotalCount = 2;

    @Bean
    public ElasticJobListener elasticJobListener() {
        return new MyElasticJobListener();
    }

    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {
        return LiteJobConfiguration.newBuilder(new SimpleJobConfiguration(
                JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                        .shardingItemParameters(shardingItemParameters).build()
                , jobClass.getCanonicalName())
        ).overwrite(true).build();
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final SimpleJobDemo simpleJob) {
        MyElasticJobListener elasticJobListener = new MyElasticJobListener();
        return new SpringJobScheduler(simpleJob, regCenter,
                getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters),
                elasticJobListener);
    }
}
