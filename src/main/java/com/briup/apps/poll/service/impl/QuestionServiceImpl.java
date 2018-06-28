package com.briup.apps.poll.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
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
}