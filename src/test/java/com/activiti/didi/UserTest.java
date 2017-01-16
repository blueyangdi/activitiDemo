package com.activiti.didi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.activiti.didi.service.UserInfoService;
import com.activiti.didi.util.LogUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml","classpath:applicationContext-activiti.xml"})
public class UserTest {

	@Autowired
	UserInfoService userInfoService;
	
	@Test
	public void test() {
		String str = userInfoService.getUserInfo().getName();
		LogUtil.getLoger().CommonLog().info(str);
	}

}
