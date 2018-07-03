package com.briup.apps.poll.service;

import java.util.List;

import com.briup.apps.poll.bean.Options;

public interface IOptionsService {
	List<Options> findAll();
	void deleteById(long id);
	void save (Options options);
	void update(Options options);
}
