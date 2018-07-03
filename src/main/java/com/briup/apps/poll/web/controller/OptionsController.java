package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;

@RestController
@RequestMapping("/options")
public class OptionsController {
	@Autowired
	private IOptionsService optionsService;
	@GetMapping("findAllOptions")
	public List<Options> findAllOptions() {
		return optionsService.findAll();
	}
  @GetMapping("deleteOptionsById")
  public String deleteOptionsById(@RequestParam long id){
	optionsService.deleteById(id);
	  return "删除成功！"; 
  }
  @GetMapping(value="/save")
  public String optionsAdd(Options options){
	optionsService.save(options);
	  return "添加成功！"; 
  }
  @GetMapping(value="/update")
  public String optionsUpdate(Options options){
	optionsService.update(options);
	  return "修改成功！";
	  
	  
  }
}
