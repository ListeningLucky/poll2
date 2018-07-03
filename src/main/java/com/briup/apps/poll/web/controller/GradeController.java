package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Grade;
import com.briup.apps.poll.service.IGradeService;
@RestController
@RequestMapping("/grade")
public class GradeController {
	@Autowired
	private IGradeService gradeService;

	@GetMapping("findAllGrade")
	public List<Grade> findAllGrade() {
		return gradeService.findAll();
	}
	@GetMapping("deleteGradeById")
	public String deleteGradeById(@RequestParam Long id){
		gradeService.deleteById(id);
		return "删除成功！";
	}
	/**
     * 添加课程信息
     *
     * @param name
     * @param description
     * @param period
     * @return
     */
	@GetMapping(value = "/save")
    public String gradeAdd(Grade grade){
		gradeService.save(grade);
		return "添加成功!";
    }
	 /**
     * 更新课程信息
     *
     * @param name
     * @param description
     * @param period
     * @return
     */
	@GetMapping(value = "/update")
    public String gradeUpdate(Grade grade){
		gradeService.save(grade);
		return "更新成功!";
    }
}
