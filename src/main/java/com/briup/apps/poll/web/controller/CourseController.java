package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Course;
import com.briup.apps.poll.service.ICourseService;
import com.briup.apps.poll.util.MsgRespose;

@RestController
@RequestMapping("/course")
public class CourseController {
@Autowired
private ICourseService courseService;

@GetMapping("batchDelete")
public MsgRespose batchDelete(Long[] ids){
	try {
		List<Long> idList=new ArrayList<>();
		for(long id:ids){
			idList.add(id);
		}
		courseService.batchDelete(idList);
		return MsgRespose.success("批量删除成功！", null);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return MsgRespose.error("删除失败！");
	
}

@GetMapping("findAllCourse")
public MsgRespose findAllCourse(){
	try {
		List<Course> list =courseService.findAll();
		return MsgRespose.success("success",list);
	} catch (Exception e) {
		return MsgRespose.error(e.getMessage());
	}
}
@GetMapping("/save")
public MsgRespose save(Course course){
	try {
		courseService.save(course);
		return MsgRespose.success("保存成功！", course);
	} catch (Exception e) {
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
	
}
@GetMapping("deleteById")
public MsgRespose deleteById(long id){
	try {
		courseService.deleteById(id);
		return MsgRespose.success("删除成功！", null);
	} catch (Exception e) {
		return MsgRespose.error("删除失败！");
	}
	
}
@GetMapping("update")
public MsgRespose update(Course course){
	try {
		courseService.update(course);
		return  MsgRespose.success("更新成功！", course);	
	} catch (Exception e) {
		return MsgRespose.error("更新失败！");
	}
	
}
@GetMapping("query")
public MsgRespose query(String keywords) throws Exception{
	List<Course> query=courseService.query(keywords);
	return MsgRespose.success("询问成功！", query);
	
}



}
