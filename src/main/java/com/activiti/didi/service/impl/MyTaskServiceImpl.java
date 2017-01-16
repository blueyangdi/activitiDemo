package com.activiti.didi.service.impl;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activiti.didi.service.MyTaskService;

@Service
public class MyTaskServiceImpl implements MyTaskService {

	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	public String startProcessInstanceByKey(String key){
		String procId = runtimeService.startProcessInstanceByKey(key).getId();
		return procId;
	}

		
}
