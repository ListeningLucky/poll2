package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;

@Service
public class SchoolServiceImpl implements ISchoolService{
	@Autowired
	private School schoolMapper;
	@Override
	public List<School>findAll(){
		return ((ISchoolService) schoolMapper).findAll();
	}
	@Override
	public void deleteById(long id) {
      //TODO Auto-generated method stub
		
	}
	
	@Override
	public void save(School school) {
		schoolMapper.save(school);
	}
	
	@Override
	public void update(School school) {
		// TODO Auto-generated method stub
		((ISchoolService) schoolMapper).update(school);
	}
}
