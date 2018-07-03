package com.briup.apps.poll.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.poll.bean.User;
import com.briup.apps.poll.service.IUserService;
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("findAllUser")
	public List<User> findAllUser() {
		return userService.findAll();
	}
	@GetMapping("deleteUserById")
	public String deleteUserById(@RequestParam Long id){
		userService.deleteById(id);
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
    public String userAdd(User user){
		userService.save(user);
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
    public String courseUpdate(User user){
		userService.save(user);
		return "更新成功!";
    }
}
