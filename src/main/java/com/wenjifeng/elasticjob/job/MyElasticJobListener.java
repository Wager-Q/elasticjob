package com.wenjifeng.elasticjob.job;

import ch.qos.logback.core.util.TimeUtil;
import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import com.wenjifeng.elasticjob.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description TODO
 * @className MyElasticJobListener
 * @Author wen_jf@suixingpay
 * @Date 2019/2/15 14:11
 * @Version 1.0
 **/
@Slf4j
public class MyElasticJobListener implements ElasticJobListener {

    private long beginTime = 0;

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        beginTime = System.currentTimeMillis();
        log.info("===>{} JOB BEGIN TIME: {} <===", shardingContexts.getJobName(), DateUtil.dateToString(new Date(), DateUtil.TimeFormater.yyyymmddHHmmss));
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        long endTime = System.currentTimeMillis();
        log.info("===>{} JOB END TIME: {},TOTAL CAST: {} <===", shardingContexts.getJobName(), DateUtil.dateToString(new Date(), DateUtil.TimeFormater.yyyymmddHHmmss), DateUtil.getHaoShiTimeMsg(beginTime));
    }
}
