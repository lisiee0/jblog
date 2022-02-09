package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	// 아이디 중복체크
	@ResponseBody
	@RequestMapping("/checkDup")
	public String checkDup(@ModelAttribute UserVo vo) {
		System.out.println("userController/checkDup()");

		return userService.checkDup(vo);
	}
	
	
	// 회원가입
	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo vo) {
		System.out.println("userController/join()");
		userService.join(vo);
		
		return "/user/joinSuccess";
	}
	

	// 로그인폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("userController/loginForm()");
		
		return "/user/loginForm";
	}
	
	
	// 로그인
	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo vo, HttpSession session) {
		System.out.println("userController/login()");
		UserVo authUser= userService.login(vo);
		
		if(authUser==null) {
			return "redirect:/user/loginForm?result=fail";
		}
		else {
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		}
	}
	
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("userController/logout()");
		
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}

}
