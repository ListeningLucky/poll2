package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.dao.QqMapper;
import com.briup.apps.poll.service.IQqService;

/**
 * <活着>
 * 
 * @author missinglxk 接待 仓库管理员
 */
@Service
public class QqServiceImpl implements IQqService {
	@Autowired
	private QqMapper qqMapper;

	@Override
	public List<Qq> findAll() {

		return qqMapper.findAll();
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Qq qq) {
		// TODO Auto-generated method stub
		qqMapper.save(qq);
	}

	@Override
	public void update(Qq qq) {
		// TODO Auto-generated method stub
		qqMapper.update(qq);
	}

}