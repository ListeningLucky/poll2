package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Questionnaire;
import com.briup.apps.poll.bean.extend.QuestionnaireVM;
import com.briup.apps.poll.service.IQuestionnaireService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {
@Autowired
private IQuestionnaireService questionnaireService;
@GetMapping("findAllQuestionnaire")
public MsgRespose findAll(){
	try {
		 List<Questionnaire> list=  questionnaireService.findAll();
		 return MsgRespose.success("查询成功！", list);
	} catch (Exception e) {
		
		e.printStackTrace();
		return MsgRespose.error("查询失败！");
	}
}
@GetMapping("deleteQuestionnaireById")
public MsgRespose deleteQuestionnaireById(long id){
	try {
		questionnaireService.deleteById(id);
		return MsgRespose.success("删除成功！",null );
				
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error("删除失败！");
	}
	
}
@GetMapping("save")
public MsgRespose questionnaireSave(Questionnaire questionnaire){
	try {
		questionnaireService.save(questionnaire);
		return MsgRespose.success("保存成功！", questionnaire);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgRespose .error("保存失败！");
	}
	
} 
@GetMapping("update")
public MsgRespose questionnaireUpdate(Questionnaire questionnaire){
	try {
		questionnaireService.update(questionnaire);
		return MsgRespose.success("修改成功！", questionnaire);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return MsgRespose .error("修改失败！");
	}

}
@ApiOperation(value="通过问卷id查找问卷")
@GetMapping("findQuestionnaireVMById")
public MsgRespose findQuestionnaireVMById(long id){
	try {
		QuestionnaireVM qvm=questionnaireService.findById(id);
		return MsgRespose.success("查询成功", qvm);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
	
}
@ApiOperation(value="保存或修改问卷信息")
@PostMapping("saveOrUpdateQuestionnaire")
public MsgRespose saveOrUpdateQuestionnaire(Questionnaire questionnaire,long[] questionIds){
	try {
		questionnaireService.saveOrUpdate(questionnaire, questionIds);
		return MsgRespose.success("保存或更新成功", null);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error("修改成功");
	}
	
}

}
