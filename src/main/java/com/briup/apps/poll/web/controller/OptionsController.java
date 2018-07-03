package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Options;
import com.briup.apps.poll.service.IOptionsService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.Api;

@Api(description="选项相关接口")
@RestController
@RequestMapping("/options")
public class OptionsController {
@Autowired
private IOptionsService optionsService;
@GetMapping("findAllOptions")
	public MsgRespose findAllOptions(){
	try {
		List<Options> list=optionsService.findAll();
		return MsgRespose.success("success", list);
	} catch (Exception e) {
		
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}
@GetMapping("queryOptions")
public MsgRespose queryOptions(String keywords){
	try {
		optionsService.query(keywords);
		return MsgRespose.success("success", "query查询成功");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}
@PostMapping("saveOrUpdateOptions")
	public MsgRespose saveOrUpdateOptions(Options options){
	try {
		optionsService.saveOrUpdate(options);
		return MsgRespose.success("success", "提交成功");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}
@GetMapping("deleteOptionsaById")
public MsgRespose deleteOptionsById(@RequestParam long id){
	try {
		optionsService.deleteById(id);
		return MsgRespose.success("success", "删除成功");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}
@GetMapping("batchdeleteOptions")
public MsgRespose batchdeleteOptions(@RequestParam List<Long> ids){
	try {
		optionsService.batchDelete(ids);
		return MsgRespose.success("success", "batch删除成功");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return MsgRespose.error(e.getMessage());
	}
}
}
