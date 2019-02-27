package com.wenjifeng.elasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.wenjifeng.elasticjob.domain.EduEdmoPmsUser;
import com.wenjifeng.elasticjob.mapper.EduEdmoPmsUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description TODO
 * @className SimpleJobDemo
 * @Author wen_jf@suixingpay
 * @Date 2019/2/15 14:09
 * @Version 1.0
 **/
@Component
@Slf4j
public class SimpleJobDemo implements SimpleJob {

    @Autowired
    private EduEdmoPmsUserMapper eduEdmoPmsUserMapper;

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("------Thread ID: %s, 任务总片数: %s, " + "当前分片项: %s.当前参数: %s,",
                Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter()
        ));
        List<EduEdmoPmsUser> list = this.eduEdmoPmsUserMapper.queryParity(shardingContext.getShardingParameter());
        log.info("==============list={}==============",list);
    }
}
