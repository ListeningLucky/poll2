package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Question;
import com.briup.apps.poll.bean.extend.QuestionVM;
import com.briup.apps.poll.service.IQuestionService;
import com.briup.apps.poll.util.MsgRespose;

@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private IQuestionService questionService;
	
	@GetMapping("saveOrUpdateQuestion")
	public MsgRespose saveOrUpdateQuestion(QuestionVM question) {
		try {		
			return MsgRespose.success("success", question);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}
	
	@GetMapping("findAllQuestion")
	public MsgRespose findAllQuestion() {
		try {
			List<Question> list = questionService.findAll();
			return MsgRespose.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@GetMapping("deleteQuestionById")
	public MsgRespose deleteQuestionById(Long id) {
		try {
			questionService.deleteById(id);
			return MsgRespose.success("删除成功！", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgRespose.error("删除失败！");
		}
	}
	 
	@GetMapping(value = "save")
	public MsgRespose questionAdd(Question question) {
		try {
			questionService.save(question);
			return MsgRespose.success("保存成功！", question);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@GetMapping(value = "update")
	public MsgRespose questionUpdate(Question question) {
		try {
			questionService.update(question);
			return MsgRespose.success("更新成功！", question);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}

	}
	
	@GetMapping("findAllQuestionVM")
	public MsgRespose findAllQuestionVM (){
		try {
			List<QuestionVM> list=questionService.findAllQuestionVM();
			return MsgRespose.success("查询成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error("查询失败！");
		}
	}
}
