package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgRespose;

@RestController
@RequestMapping("/answers")

public class AnswersController {
@Autowired
private IAnswersService answersService;
@GetMapping("findAllAnswers")
public MsgRespose findAllAnswers(){
	try {
		List<Answers> list=answersService.findAll();
		return MsgRespose.success("查询成功！", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}

@GetMapping("save")
public MsgRespose save(Answers answers){
	try {
		answersService.save(answers);
		return MsgRespose.success("保存成功！", answers);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}
@GetMapping("update")
public MsgRespose update(Answers answers){
	try {
		answersService.update(answers);
		return MsgRespose.success("修改成功！", answers);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}
@GetMapping("batchDelete")
public MsgRespose batchDelete(Long[] ids){
	try {
		answersService.batchDelete(ids);
		return MsgRespose.success("删除成功！", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}	
}
@GetMapping("deleteById")
public MsgRespose deleteById(long id){
	try {
		answersService.deleteById(id);
		return MsgRespose.success("删除成功！", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
	
}
}


