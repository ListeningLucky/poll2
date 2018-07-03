package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.School;
import com.briup.apps.poll.service.ISchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
@Autowired
private ISchoolService schoolService;
@GetMapping("findAllSchool")
public List<School>findAllSchool(){
    return schoolService.findAll();	
}
@GetMapping("deleteSchoolById")
public String deleteSchoolById(@RequestParam long id){
	schoolService.deleteById(id);
	  return "删除成功！"; 
}
@GetMapping(value="/save")
public String schoolAdd(School school){
	schoolService.save(school);
	  return "添加成功！"; 
}
@GetMapping(value="/update")
public String schoolUpdate(School school){
	schoolService.update(school);
	  return "修改成功！";
	  
}
}
