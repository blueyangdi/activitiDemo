package com.activiti.didi.controller;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activiti.didi.service.UserInfoService;
import com.activiti.didi.util.LogUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class TestController {

	@Autowired
	UserInfoService userInfoService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	/**
	 * 查询所有发布任务
	 * @return
	 */
	@RequestMapping(value = "queryTask", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryTask() {
		LogUtil.getLoger().CommonLog().info("查询所有发布的任务");
		List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
				.orderByProcessDefinitionVersion().asc().list();
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArry = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			JSONObject jsonObj1 = new JSONObject();
			jsonObj1.put("name", list.get(i).getName());
			jsonObj1.put("key", list.get(i).getKey());
			jsonObj1.put("id", list.get(i).getId());
			jsonArry.add(jsonObj1);
		}
		jsonObj.put("rows", jsonArry);
		jsonObj.put("total", list.size());
		return jsonObj.toJSONString();
	}
	
	/**
	 * 根据任务key执行任务
	 * @return
	 */
	@RequestMapping(value = "runTask", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String runTask(String taskKey) {
		LogUtil.getLoger().CommonLog().info("触发任务,任务key："+taskKey);
		
		return runtimeService.startProcessInstanceByKey(taskKey).getId();
	}
	
	
	
	
	/**
	 * 查询员工历史任务
	 * @return
	 */
	@RequestMapping(value = "queryOperatorHiTask", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryOperatorHiTask() {
		LogUtil.getLoger().CommonLog().info("查询员工已办任务");
		List<HistoricTaskInstance> hiTaskList = historyService.createHistoricTaskInstanceQuery().taskAssignee("员工").list();
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArry = new JSONArray();
		for (int i = 0; i < hiTaskList.size(); i++) {
			JSONObject jsonObj1 = new JSONObject();
			jsonObj1.put("name", hiTaskList.get(i).getName());
			jsonObj1.put("Assignee", hiTaskList.get(i).getAssignee());
			jsonObj1.put("creatTime", hiTaskList.get(i).getCreateTime());
			jsonObj1.put("owner", hiTaskList.get(i).getOwner());
			jsonObj1.put("taskId", hiTaskList.get(i).getId());
			jsonArry.add(jsonObj1);
		}
		jsonObj.put("rows", jsonArry);
		jsonObj.put("total", hiTaskList.size());
		return jsonObj.toJSONString();
	}
	
	/**
	 * 查询员工待办任务
	 * @return
	 */
	@RequestMapping(value = "queryOperatorTask", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryOperatorTask() {
		LogUtil.getLoger().CommonLog().info("查询员工待办任务");
		List<Task> taskList = taskService.createTaskQuery().taskAssignee("员工").list();
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArry = new JSONArray();
		for (int i = 0; i < taskList.size(); i++) {
			JSONObject jsonObj1 = new JSONObject();
			jsonObj1.put("name", taskList.get(i).getName());
			jsonObj1.put("Assignee", taskList.get(i).getAssignee());
			jsonObj1.put("creatTime", taskList.get(i).getCreateTime());
			jsonObj1.put("owner", taskList.get(i).getOwner());
			jsonObj1.put("taskId", taskList.get(i).getId());
			jsonArry.add(jsonObj1);
		}
		jsonObj.put("rows", jsonArry);
		jsonObj.put("total", taskList.size());
		return jsonObj.toJSONString();
	}
	
	/**
	 * 查询审核员待办任务
	 * @return
	 */
	@RequestMapping(value = "queryAuditorTask", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryAuditorTask() {
		LogUtil.getLoger().CommonLog().info("查询审核员待办任务");
		List<Task> taskList = taskService.createTaskQuery().taskAssignee("经理").list();
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArry = new JSONArray();
		for (int i = 0; i < taskList.size(); i++) {
			JSONObject jsonObj1 = new JSONObject();
			jsonObj1.put("name", taskList.get(i).getName());
			jsonObj1.put("Assignee", taskList.get(i).getAssignee());
			jsonObj1.put("creatTime", taskList.get(i).getCreateTime());
			jsonObj1.put("owner", taskList.get(i).getOwner());
			jsonObj1.put("taskId", taskList.get(i).getId());
			jsonArry.add(jsonObj1);
		}
		jsonObj.put("rows", jsonArry);
		jsonObj.put("total", taskList.size());
		return jsonObj.toJSONString();
	}
	
	
	/**
	 * 查询审核员历史任务
	 * @return
	 */
	@RequestMapping(value = "queryqueryAuditorHiTask", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String queryqueryAuditorHiTask() {
		LogUtil.getLoger().CommonLog().info("查询审核员已办任务");
		List<HistoricTaskInstance> hiTaskList = historyService.createHistoricTaskInstanceQuery().taskAssignee("经理").list();
		
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArry = new JSONArray();
		for (int i = 0; i < hiTaskList.size(); i++) {
			JSONObject jsonObj1 = new JSONObject();
			jsonObj1.put("name", hiTaskList.get(i).getName());
			jsonObj1.put("Assignee", hiTaskList.get(i).getAssignee());
			jsonObj1.put("creatTime", hiTaskList.get(i).getCreateTime());
			jsonObj1.put("owner", hiTaskList.get(i).getOwner());
			jsonObj1.put("taskId", hiTaskList.get(i).getId());
			jsonArry.add(jsonObj1);
		}
		jsonObj.put("rows", jsonArry);
		jsonObj.put("total", hiTaskList.size());
		return jsonObj.toJSONString();
	}
	
	/**
	 * 提交申请
	 * @return
	 */
	@RequestMapping(value = "commitTask", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String commitTask(String taskId) {
		LogUtil.getLoger().CommonLog().info("员工提交请假申请");
		taskService.complete(taskId);
		return "success";
}
	
	
}

