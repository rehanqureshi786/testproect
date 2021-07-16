package com.springmvcflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvcflow.dao.UserDaoImpl;
import com.springmvcflow.model.User;

interface UserService
{
public boolean addUser(User user);
public List<User> getUser();
}

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDaoImpl userDao;
	
	
	
	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
		
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.getUser();
	}
	
	

}
