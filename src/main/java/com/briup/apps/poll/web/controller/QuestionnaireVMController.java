 package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.ApiOperation;

public class QuestionnaireVMController {
@Autowired
private IQuestionnaireService questionnaireService;
@ApiOperation(value="查询所有问卷")
@GetMapping("findAllQuestionnaire")
public MsgRespose findAllQuestionnaire(){
	try {
		List<Questionnaire> list=questionnaireService.findAll();
		return MsgRespose.success("success", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error("查询失败");
	}	
}
@GetMapping("findQuestionnaireVMById")
public MsgRespose findQuestionnaireVMById(long id){
	try {
		QuestionnaireVM qvm=questionnaireService.findById(id);
		return MsgRespose.success("查询成功", qvm);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error("查询失败");
	}
}
@GetMapping("deleteQuestionnaireById")
public MsgRespose deleteQuestionnaireById(long id){
	try {
		questionnaireService.deleteById(id);
		return MsgRespose.success("查询成功", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error("查询失败");
	}
}
@GetMapping("findAllQuestionnire")
public MsgRespose findAllQuestionnire(){
	try {
		List<Questionnaire> list=questionnaireService.findAll();
		return MsgRespose.success("查询成功", list);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
	
}
}
