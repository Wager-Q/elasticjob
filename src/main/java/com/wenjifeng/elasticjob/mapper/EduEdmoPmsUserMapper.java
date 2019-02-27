package com.wenjifeng.elasticjob.mapper;

import com.wenjifeng.elasticjob.domain.EduEdmoPmsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @className EduEdmoPmsUserMapper
 * @Author wen_jf@suixingpay
 * @Date 2019/1/19 14:49
 * @Version 1.0
 **/
//@Mapper
public interface EduEdmoPmsUserMapper {
    public int insert(EduEdmoPmsUser eduEdmoPmsUser) ;

    public EduEdmoPmsUser queryById(String id);

    public List<EduEdmoPmsUser> queryParity(String parity);
}
