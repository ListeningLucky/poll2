package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.User;

public interface IUserService {
	List<User> findAll();
	void deleteById(long id);
	void save(User user);
	void update(User user);
}
