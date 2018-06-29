package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.QqExample;
import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.QuestionnaireExample;
import com.briup.apps.poll.bean.QuestionnaireQuestion;
import com.briup.apps.poll.bean.QuestionnaireQuestionExample;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.dao.QqMapper;
import com.briup.apps.poll.dao.QuestionnaireMapper;
import com.briup.apps.poll.dao.extend.QuestionnaireVMMapper;
import com.briup.apps.poll.service.IQuestionnaireService;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
	@Autowired
	private QuestionnaireMapper questionnaireMapper;
	@Autowired
	private QuestionnaireVMMapper questionnaireVMMapper;
	@Autowired
	private QqMapper qqMapper;
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
	@Override
	public void saveOrUpdate(Questionnaire questionnaire, long[] ids) throws Exception {
	if(questionnaire.getId()==null){
		questionnaireMapper.insert(questionnaire);
       for(long id:ids){
			QuestionnaireQuestion qq=new QuestionnaireQuestion();
			qq.setQuestionId(id);
			qq.setQuestionnaireId(questionnaire.getId());
			qqMapper.insert(qq);
		}
		
	}else{ 
		questionnaireMapper.updateByPrimaryKey(questionnaire);
		QqExample qqExample=new QqExample();
		qqExample.createCriteria().andQuestionIdEqualTo(questionnaire.getId());
		qqMapper.deleteByExample(qqExample);
		for(long id:ids){
			QuestionnaireQuestion qq=new QuestionnaireQuestion();
			qq.setQuestionId(id);
			qq.setQuestionnaireId(questionnaire.getId());
			qqMapper.insert(qq);
		}
	}
		
	}
	@Override
	public QuestionnaireVM findById(long id) throws Exception {
		
		return questionnaireVMMapper.selectById(id);
	}
	
}
