package com.activiti.didi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.activiti.didi.service.MyTaskService;
import com.activiti.didi.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml","classpath:applicationContext-activiti.xml"})
public class TestMyTask extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MyTaskService myTaskService;

	@Test
	public void startTask() {
		String id = myTaskService.startProcessInstanceByKey("myProcess");
		LogUtil.getLoger().CommonLog().info(id);
	}

}
