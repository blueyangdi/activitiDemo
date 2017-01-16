package com.activiti.didi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activiti.didi.service.MyTaskService;
import com.activiti.didi.service.UserInfoService;
import com.activiti.didi.util.LogUtil;

@Controller
public class TestController {

	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	private MyTaskService myTaskService;
	
	@RequestMapping("test")
	@ResponseBody
	public String test() {
		LogUtil.getLoger().CommonLog().info("测试日志");
		String id = myTaskService.startProcessInstanceByKey("myProcess");
		LogUtil.getLoger().CommonLog().info(id);
		return userInfoService.getUserInfo().getName();
	}
}
