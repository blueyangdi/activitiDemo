package com.activiti.didi;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext-dao.xml","classpath:applicationContext-activiti.xml"})
public class CreatGroupTest {

	 @Autowired
	 IdentityService identityService;
	 
	 //1、创建用户组
	 @Test
	 public void creatGroupService(){
		 Group group=identityService.newGroup("1");
		 group.setName("经理组");
		 group.setType("manager");
		 
		 identityService.saveGroup(group);
		 
		 System.out.println("创建用户组完成");
		 
		 
	 }
	 
	 //2查询用户组
	 @Test
	 public void queryGroup(){
		 	List<Group> list = identityService.createGroupQuery().list();
		 	for(Group data:list){
		 		System.out.println(data.getId()+"--"+data.getName());
		 	}
		 	
		 	System.out.println("组查询完毕");
	 }
	 
	 //3 添加用户
	 @Test
	 public void creatUser(){
		 User user=identityService.newUser("新用户ID1");
		 user.setFirstName("张");
		 user.setLastName("三");
		 user.setEmail("111@qq.com");
		 user.setPassword("11111");
		 identityService.saveUser(user);
		 System.out.println("添加用户完成");
	 }
			 
	 
	 //4 为用户设置组
	 @Test
	 public void setUserByGroup(){
		 identityService.createMembership("新用户ID1", "1");
		 System.out.println("用户与组的关系绑定完成");
	 }
}
