package com.activiti.didi.controller;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
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
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("test")
	@ResponseBody
	public String test() {
		LogUtil.getLoger().CommonLog().info("测试日志");
		String name = "杨迪个人";
		String id = myTaskService.startProcessInstanceByKey("helloProcess");
		List<Task> taskList = taskService.createTaskQuery().taskAssignee(name).list();
		for (int i = 0; i < taskList.size(); i++) {
			System.out.println(taskList.get(i).getAssignee());
			System.out.println(taskList.get(i).getDescription());
			System.out.println(taskList.get(i).getName());
			System.out.println(taskList.get(i).getOwner());
			System.out.println(taskList.get(i).getId());
		}
		taskService.complete(taskList.get(0).getId());
		
		LogUtil.getLoger().CommonLog().info(id);
		return userInfoService.getUserInfo().getName();
	}
}
