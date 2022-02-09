package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// 회원가입폼
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("userController/joinForm()");
		
		return "/user/joinForm";
	}
	
	// 회원가입
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		System.out.println("userController/join()");
		System.out.println(vo);
		userService.join(vo);
		
		return "/user/joinSuccess";
	}
	
	
	
	
	
	// 로그인폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("userController/loginForm()");
		
		return "/user/loginForm";
	}
	
	
	
	

}
