package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.service.IGradeService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.Api;

@Api(description="成绩相关接口")
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;
	@GetMapping("findAllGrade")
	public MsgRespose findAllGrade(){
		try {
			List<Grade> list=gradeService.findAll();
			return MsgRespose.success("success", list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}
	
	@GetMapping("queryGrade")
	public MsgRespose queryGrade(String keywords){
		try {
			gradeService.query(keywords);
			return MsgRespose.success("success", "query查询成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}
	@PostMapping("saveOrUpdateGrade")
	public MsgRespose saveOrUpdateGrade(Grade grade){
		try {
			gradeService.saveOrUpdate(grade);
			return MsgRespose.success("success", grade);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}
	
	@GetMapping("deleteGradesById")
	public MsgRespose deleteGradeById(@RequestParam long id){
		try {
			gradeService.deleteById(id);
			return MsgRespose.success("success", "删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}
	@GetMapping("batchdeleteGrade")
	public MsgRespose batchdeleteGrade(@RequestParam List<Long> ids){
		try {
			gradeService.batchDelete(ids);
			return MsgRespose.success("success", "batch删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}
}
