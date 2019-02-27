package com.wenjifeng.elasticjob;

import com.wenjifeng.elasticjob.domain.EduEdmoPmsUser;
import com.wenjifeng.elasticjob.mapper.EduEdmoPmsUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ElasticjobApplicationTests {

	@Autowired
	private EduEdmoPmsUserMapper eduEdmoPmsUserMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void TestQuery() {
		EduEdmoPmsUser eduEdmoPmsUser = this.eduEdmoPmsUserMapper.queryById("2");
		log.info("查询返回结果：{}",eduEdmoPmsUser);
	}

}

