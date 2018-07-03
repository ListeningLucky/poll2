package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.service.IQqService;

@RestController
@RequestMapping("/qq")
public class QqController {
@Autowired
private IQqService qqService;
@GetMapping("findAllQq")
public List<Qq>findAllQq(){
	return qqService.findAll();
}
@GetMapping("deleteQqById")
public String deleteQqById(@RequestParam long id){
	qqService.deleteById(id);
	return "删除成功！";
}
@GetMapping(value="/save")
public String qqAdd(Qq qq){
	qqService.save(qq);
	return "添加成功！";
}
@GetMapping(value="/update")
public String qqUpdate(Qq qq){
	qqService.update(qq);
	return "修改成功";
}
}
