package com.briup.apps.poll.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.dao.SurveyMapper;
import com.briup.apps.poll.dao.extend.SurveyVMMapper;
import com.briup.apps.poll.service.ISurveyService;
@Service
public class SurveyServeyImpl implements ISurveyService{
@Autowired
    private SurveyMapper surveyMapper;
@Autowired
private SurveyVMMapper surveyVMMapper;
@Override
	public void saveOrUpdateSurvey(Survey survey) throws Exception {
		survey.setStatus(survey.STATUS_INIT);
		survey.setCode("");
		Date surveyDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String str=sdf.format(surveyDate);
		survey.setSurveydate(str);
		surveyMapper.insert(survey);
	}
@Override
public List<SurveyVM> findAll() throws Exception {
	// TODO Auto-generated method stub
	return surveyVMMapper.findAll();
}
@Override
public SurveyVM findById(long id) throws Exception {
	// TODO Auto-generated method stub
	return surveyVMMapper.findById();
}
	
	

}
