package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.bean.GradeExample;
import com.briup.apps.poll.dao.GradeMapper;
import com.briup.apps.poll.service.IGradeService;
@Service
public class GradeServiceImpl implements IGradeService{
@Autowired
private GradeMapper gradeMapper;
	@Override
	public List<Grade> findAll() throws Exception {
		// TODO Auto-generated method stub
		GradeExample example=new GradeExample();
		return gradeMapper.selectByExample(example);
	}

	@Override
	public Grade findById(long id) throws Exception {
		// TODO Auto-generated method stub
		return gradeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Grade> query(String keywords) throws Exception {
		// TODO Auto-generated method stub
		GradeExample example=new GradeExample();
		example.createCriteria().andNameLike(keywords);
		return gradeMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void saveOrUpdate(Grade grade) throws Exception {
		// TODO Auto-generated method stub
		if(grade.getId()!=null){
		gradeMapper.updateByPrimaryKey(grade);
		}else{
			gradeMapper.insert(grade);
			
		}
	}

	@Override
	public void deleteById(long id) throws Exception {
		// TODO Auto-generated method stub
		gradeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void batchDelete(List<Long> ids) throws Exception {
		// TODO Auto-generated method stub

		for( long id : ids)
		gradeMapper.deleteByPrimaryKey(id);
	}

}
