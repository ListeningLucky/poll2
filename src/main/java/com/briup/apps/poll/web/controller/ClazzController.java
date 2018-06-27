package com.briup.apps.poll.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.poll.bean.Clazz;
import com.briup.apps.poll.bean.extend.ClazzVM;
import com.briup.apps.poll.service.IClazzService;
import com.briup.apps.poll.util.MsgRespose;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "班级相关接口")
@RestController
@RequestMapping("/clazz")

public class ClazzController {

	@Autowired
	private IClazzService clazzService;

	@GetMapping("batchDelete")
	public MsgRespose batchDelete(Long[] ids) {
		try {
			List<Long> idList = new ArrayList<>();
			for (long id : ids) {
				idList.add(id);
			}
			clazzService.batchDelete(idList);
			return MsgRespose.success("批量删除成功！", idList);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return MsgRespose.error("删除失败！");
		}
	}

	@GetMapping("deleteByIdClazz")
	public MsgRespose deleteByIdClazz(long id) {
		try {
			clazzService.deleteById(id);
			return MsgRespose.success("success", null);
		} catch (Exception e) {

			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@ApiOperation("查询所有的班级信息")
	@GetMapping("findAllClazz")
	public MsgRespose findAllClazz() {
		try {
			List<Clazz> list = clazzService.findAll();
			return MsgRespose.success("success", list);
		} catch (Exception e) {
			return MsgRespose.error(e.getMessage());
		}

	}

	@GetMapping("findAllClazzVM")
	public MsgRespose findAllClazzVM() {
		try {
			List<ClazzVM> list = clazzService.findAllClazzVM();
			return MsgRespose.success("success", list);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}

	}

	@GetMapping("save")
	public MsgRespose save(Clazz clazz) {
		try {
			clazzService.save(clazz);
			return MsgRespose.success("success", clazz);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}

	@GetMapping("update")
	public MsgRespose update(Clazz clazz) {
		try {
			clazzService.update(clazz);
			return MsgRespose.success("success", clazz);
		} catch (Exception e) {

			e.printStackTrace();
			return MsgRespose.error(e.getMessage());
		}
	}
}
