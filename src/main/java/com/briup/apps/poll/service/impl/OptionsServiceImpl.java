package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.service.IOptionsService;

/**
 * <活着>
 * 
 * @author missinglxk 接待 仓库管理员
 */
@Service
public class OptionsServiceImpl implements IOptionsService {
	@Autowired
	private OptionsMapper optionsMapper;

	@Override
	public List<Options> findAll() {

		return optionsMapper.findAll();
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Options options) {
		// TODO Auto-generated method stub
		optionsMapper.save(options);
	}

	@Override
	public void update(Options options) {
		// TODO Auto-generated method stub
		optionsMapper.update(options);
	}
}