package com.activiti.didi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activiti.didi.dao.UserInfoDao;
import com.activiti.didi.dao.interfaces.UserinfoMapper;
import com.activiti.didi.dao.model.Userinfo;
import com.activiti.didi.dao.model.UserinfoExample;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	UserinfoMapper userinfoMapper;
	
	@Override
	public Userinfo getUserInfo() {
		// TODO Auto-generated method stub
		UserinfoExample  example = new UserinfoExample();
		example.createCriteria().andIdIsNotNull();
		return userinfoMapper.selectByExample(example).get(0);
	}

}
