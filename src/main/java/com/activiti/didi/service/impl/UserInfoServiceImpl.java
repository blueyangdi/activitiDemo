package com.activiti.didi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activiti.didi.dao.UserInfoDao;
import com.activiti.didi.dao.model.Userinfo;
import com.activiti.didi.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	UserInfoDao userInfoDao;
	@Override
	public Userinfo getUserInfo() {
		// TODO Auto-generated method stub
		return userInfoDao.getUserInfo();
	}

}
