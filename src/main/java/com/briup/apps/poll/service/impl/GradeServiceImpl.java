package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.service.IGradeService;

/**
 * <活着>
 * 
 * @author missinglxk 接待 仓库管理员
 */
@Service
public class GradeServiceImpl implements IGradeService {
	@Autowired
	private GradeMapper gradeMapper;

	@Override
	public List<Grade> findAll() {

		return gradeMapper.findAll();
	}
	@Override
	public void deleteById(long id) {
      //TODO Auto-generated method stub
		
	}
	
	@Override
	public void save(Grade grade) {
		gradeMapper.save(grade);
	}
	@Override
	public void update(Grade grade) {
		gradeMapper.update(grade);
	}
}
