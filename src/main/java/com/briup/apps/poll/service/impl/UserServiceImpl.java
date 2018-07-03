package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.dao.UserMapper;
import com.briup.apps.poll.service.IUserService;

/**
 * <活着>
 * 
 * @author missinglxk 接待 仓库管理员
 */
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAll() {

		return userMapper.findAll();
	}
	@Override
	public void deleteById(long id) {
      //TODO Auto-generated method stub
		
	}
	
	@Override
	public void save(User User) {
		userMapper.save(User);
	}
	@Override
	public void update(User User) {
		userMapper.update(User);
	}
}
