package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Answers;
import com.briup.apps.poll.service.IAnswersService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/answers")
@Api(description = "答卷的相应接口")
public class AnswersController {
	@Autowired
	private IAnswersService answersService;

	@GetMapping("findAllAnswers")
	public MsgRespose findAllAnswers() {
		try {
			List<Answers> list = answersService.findAll();
			return MsgRespose.success("查询成功！", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@GetMapping("save")
	public MsgRespose save(Answers answers) {
		try {
			answersService.save(answers);
			return MsgRespose.success("保存成功！", answers);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@GetMapping("update")
	public MsgRespose update(Answers answers) {
		try {
			answersService.update(answers);
			return MsgRespose.success("修改成功！", answers);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@GetMapping("batchDelete")
	public MsgRespose batchDelete(Long[] ids) {
		try {
			answersService.batchDelete(ids);
			return MsgRespose.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@GetMapping("deleteById")
	public MsgRespose deleteById(long id) {
		try {
			answersService.deleteById(id);
			return MsgRespose.success("删除成功！", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}

	}

	@ApiOperation(value = "提交答卷，每个学生提交一份答卷")
	@PostMapping("submitAnswer")
	public MsgRespose submitAnswer(Answers answers) {
		//1、看用户是否具有答卷的权限，看是否提交过问卷
		//2、保存答卷信息
		try {
       answersService.saveOrUpdate(answers);
       return MsgRespose.success("保存成功，您的意见是我们的改进方向", answers);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage() ); 
		}

	}
}
