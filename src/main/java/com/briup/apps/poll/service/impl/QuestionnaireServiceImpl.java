package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.service.IQuestionnaireService;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Override
	public List<Questionnaire> findAll() throws Exception{	
		QuestionnaireExample example =new QuestionnaireExample();
		return questionnaireMapper.selectByExampleWithBLOBs(example);
	}
	@Override
	public void deleteById(long id) throws Exception{
		questionnaireMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void save(Questionnaire questionnaire) throws Exception{
		questionnaireMapper.insert(questionnaire);
;
	}
	@Override
	public void update(Questionnaire questionnaire) throws Exception{
		
		questionnaireMapper.updateByPrimaryKey(questionnaire);
	}
}
