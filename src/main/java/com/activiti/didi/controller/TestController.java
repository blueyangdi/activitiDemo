package com.activiti.didi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activiti.didi.service.UserInfoService;
import com.activiti.didi.util.LogUtil;

@Controller
public class TestController {

	@Autowired
	UserInfoService userInfoService;
	
	@RequestMapping("test2")
	@ResponseBody
	public String test() {
		LogUtil.getLoger().CommonLog().info("测试日志");

		return userInfoService.getUserInfo().getName();
	}
}
