package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Survey;
import com.briup.apps.poll.bean.extend.SurveyVM;
import com.briup.apps.poll.service.ISurveyService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/survey")
public class SurveyController {
@Autowired
	private ISurveyService surveyService;
@ApiOperation(value="通过ID查询",notes="级联查询课调关联的课程，班级，讲师，问卷")
@GetMapping(value="findSurveyById")
	public MsgRespose findSurveyById(long id){
	try {
	 SurveyVM surveyVM=surveyService.findById(id);
		return MsgRespose.success("success", surveyVM);
	} catch (Exception e) {
		return MsgRespose.error(e.getMessage());
	}
	
}
@ApiOperation(value="级联查询",notes="级联查询课调关联的课程，班级，讲师，问卷")
@GetMapping(value="findAllSurvey")
	public MsgRespose findAllSurvey(){
	try {
		List<SurveyVM> list=surveyService.findAll();
		return MsgRespose.success("success", list);
	} catch (Exception e) {
		return MsgRespose.error(e.getMessage());
	}
	
}

@ApiOperation(value="保存与更新课调",notes="只需要输入courseId,userId,clzz_Id,questinnsireId")
@PostMapping(value="saveOrUpadteSurvey")
	public MsgRespose saveOrUpadteSurvey(Survey survey){
	try {
		surveyService.saveOrUpdateSurvey(survey);
		return MsgRespose.success("保存与更新课调成功", null);
	} catch (Exception e) {
		return MsgRespose.error(e.getMessage());
	}
	
}
	
}
