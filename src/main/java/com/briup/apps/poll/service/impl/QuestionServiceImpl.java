package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.dao.OptionsMapper;
import com.briup.apps.poll.dao.QuestionMapper;
import com.briup.apps.poll.dao.extend.QuestionVMMapper;
import com.briup.apps.poll.service.IQuestionService;

/**
 * <活着>
 * 
 * @author missinglxk 接待 仓库管理员
 */
@Service
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private QuestionMapper questionMapper;
@Autowired
private QuestionVMMapper questionVMMapper;
@Autowired
private OptionsMapper optionsMapper;
	@Override
	public List<Question> findAll() throws Exception {
     
		return questionMapper.findAll();
	}

	@Override
	public void deleteById(long id) throws Exception{
		questionMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void save(Question Question) throws Exception{
		// TODO Auto-generated method stub
		questionMapper.insert(Question);
	}

	@Override
	public void update(Question Question) throws Exception{
		// TODO Auto-generated method stub
		questionMapper.updateByPrimaryKey(Question);
	}

	@Override
	public List<QuestionVM> findAllQuestionVM() throws Exception {
		// TODO Auto-generated method stub
		return questionVMMapper.selectAll();
	}

	@Override
	public void saveOrUpdate(QuestionVM questionVM) throws Exception {
      Question question=new Question();
      question.setId(questionVM.getId());
      question.setName(questionVM.getName());
      question.setQuestiontype(questionVM.getQuestionType());
      List<Options> options=questionVM.getOptions();
      if(question.getId()!=null){
    	  
      }else{
    	  
    	  questionMapper.insert(question);
    	  long id=question.getId();
    	  for(Options option:options){
    		  option.setQuestionId(id); 
    		  optionsMapper.insert(option);
    		  
    	  }
      }
		
	}
}